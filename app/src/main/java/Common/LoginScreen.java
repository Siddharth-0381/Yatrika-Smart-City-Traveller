package Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yatrika_travel.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import ForgetPasswordProcess.FetchEmail;
import LoginProcess.HomePage;
import SignInProcess.SignInPage1;

public class LoginScreen extends AppCompatActivity {


    private TextInputLayout phoneNumber;
    private CountryCodePicker countryCodePicker;
    private TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        phoneNumber = findViewById(R.id.phoneNumber);
        countryCodePicker = findViewById(R.id.country_code_picker);
        password = findViewById(R.id.password_field);
    }

    public void openSignInScreen1(View view) {
        Intent intent = new Intent(LoginScreen.this, SignInPage1.class);
        startActivity(intent);
    }

    public void openHomePage(View view) {

        if (!isConnected(this)) {
            showCustomDialogue();
        }
        if (!validateNumber() | !validatePassword()) {
            return;
        }

        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();

        if (_phoneNumber.charAt(0) == '0') {
            _phoneNumber = _phoneNumber.substring(1);
        }
        String _phoneNo = "+" + countryCodePicker.getFullNumber() + _phoneNumber;

        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_phoneNo);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);

                    String systemPassword = snapshot.child(_phoneNo).child("password").getValue(String.class);
                    if (systemPassword.equals(_password)) {
                        password.setError(null);
                        password.setErrorEnabled(false);

                        String _fullname = snapshot.child(_phoneNo).child("fullname").getValue(String.class);
                        Intent intent = new Intent(LoginScreen.this, HomePage.class);
                        intent.putExtra("fullname",_fullname);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginScreen.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginScreen.this, "No such user exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LoginScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showCustomDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginScreen.this);
        builder.setMessage("Ensure that you are connected to the internet.").setCancelable(false).setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), SplashScreen.class));
                        finish();
                    }
                });
    }

    private boolean isConnected(LoginScreen loginScreen) {

        ConnectivityManager connectivityManager = (ConnectivityManager) loginScreen.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    public void openFetchEmailPage(View view) {
        Intent intent = new Intent(LoginScreen.this, FetchEmail.class);
        startActivity(intent);
    }

    private boolean validateNumber() {
        String val = phoneNumber.getEditText().getText().toString();
        if (val.isEmpty()) {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            phoneNumber.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +
                //"(?=.*[a-z])" +
                //"(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{7,}" +
                "$";
        if (val.isEmpty()) {
            password.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password must contain\natleast 1 special character\nno white space\nmust be 7 character or more!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}