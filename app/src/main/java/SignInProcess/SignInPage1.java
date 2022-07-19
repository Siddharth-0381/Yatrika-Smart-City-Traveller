package SignInProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.yatrika_travel.R;
import com.google.android.material.textfield.TextInputLayout;

import Common.LoginScreen;

public class SignInPage1 extends AppCompatActivity {

    TextInputLayout name, email, password, username;
    RadioGroup selectedGender;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page1);

        name = findViewById(R.id.name_field);
        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);
        username = findViewById(R.id.username_field);
        btn = findViewById(R.id.next_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validatename() | !validateusername() | !validateEmailid() | !validatePassword()) {
                    return;
                }
                String _name = name.getEditText().getText().toString();
                String _email = email.getEditText().getText().toString();
                String _username = username.getEditText().getText().toString();
                String _password = password.getEditText().getText().toString();
                Intent intent = new Intent(SignInPage1.this, SignInPage2.class);
                intent.putExtra("Name", _name);
                intent.putExtra("EmailID", _email);
                intent.putExtra("Username",_username);
                intent.putExtra("Password", _password);
                startActivity(intent);
            }
        });
    }

    public void openLoginPage(View view)
    {
        Intent intent = new Intent(SignInPage1.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

    private boolean validatename() {
        String val = name.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            name.setError("Field cannot be empty!");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateusername() {
        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field cannot be empty!");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too big!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("No white spaces allowed!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmailid() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0_9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
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