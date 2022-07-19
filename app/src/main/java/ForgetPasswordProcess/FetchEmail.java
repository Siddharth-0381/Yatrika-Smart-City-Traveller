package ForgetPasswordProcess;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import Common.LoginScreen;
import Common.SplashScreen;

public class FetchEmail extends AppCompatActivity {

    private TextInputLayout phoneNumber;
    private CountryCodePicker countryCodePicker;
    Button nxtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch_email);

        phoneNumber = findViewById(R.id.phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);
        nxtButton = findViewById(R.id.next_button);
    }

    public void openLoginScreen(View view) {
        Intent intent = new Intent(FetchEmail.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

    public void openOtppage(View view) {

        //CheckInternet checkInternet = new CheckInternet();
        if (!isConnected(FetchEmail.this)) {
            showCustomDialogue();
        }
        if (!validateNumber()) {
            return;
        }
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
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


                    Intent intent = new Intent(FetchEmail.this, OTPForget.class);
                    intent.putExtra("PhoneNumber", _phoneNo);
                    intent.putExtra("whattodo","updateData");
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(FetchEmail.this, "No such user exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FetchEmail.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
            });
    }

    private void showCustomDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FetchEmail.this);
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

    private boolean isConnected(FetchEmail FetchEmail) {

        ConnectivityManager connectivityManager = (ConnectivityManager) FetchEmail.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
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
}