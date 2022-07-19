package ForgetPasswordProcess;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Common.SplashScreen;

public class newCredentialsScreen extends AppCompatActivity {

    private TextInputLayout newpassword, confirmpassword;
    String numberS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_credentials_screen);

        newpassword = findViewById(R.id.new_password);
        confirmpassword = findViewById(R.id.confirm_password);

        numberS = getIntent().getStringExtra("phoneNumber");
    }

    public void setNewPasswordBtn(View view) {

        if (!isConnected(newCredentialsScreen.this)) {
            showCustomDialogue();
        }
        if(!validateNewPassword() | !validateConfirmPassword())
        {
            return;
        }
        String _newPassword = newpassword.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(numberS).child("password").setValue(_newPassword);

        startActivity(new Intent(newCredentialsScreen.this,UpdateePage.class));
        finish();
    }
    private void showCustomDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(newCredentialsScreen.this);
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

    private boolean isConnected(newCredentialsScreen newCredentialsScreen) {

        ConnectivityManager connectivityManager = (ConnectivityManager) newCredentialsScreen.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateNewPassword() {
        String val = newpassword.getEditText().getText().toString().trim();
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
            newpassword.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            newpassword.setError("Password must contain\natleast 1 special character\nno white space\nmust be 7 character or more!");
            return false;
        } else {
            newpassword.setError(null);
            newpassword.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String val = confirmpassword.getEditText().getText().toString().trim();
        String val1 = newpassword.getEditText().getText().toString().trim();
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
            confirmpassword.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkPassword)) {
            confirmpassword.setError("Password must contain\natleast 1 special character\nno white space\nmust be 7 character or more!");
            return false;
        } else if(val != val){
            confirmpassword.setError("Should match with newPassword Field!");
            return false;
        } else{
            confirmpassword.setError(null);
            confirmpassword.setErrorEnabled(false);
            return true;
        }
    }
}