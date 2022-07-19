package SignInProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yatrika_travel.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignInPage2 extends AppCompatActivity {

    TextInputLayout phoneNumber;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    CountryCodePicker selectedCode;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page2);

        radioGroup = findViewById(R.id.gender_checkbox);
        phoneNumber = findViewById(R.id.phone_number);
        selectedCode = findViewById(R.id.country_code_picker);
        btn = findViewById(R.id.submit_button);

        String name = getIntent().getStringExtra("Name");
        String username = getIntent().getStringExtra("Username");
        String email = getIntent().getStringExtra("EmailID");
        String password = getIntent().getStringExtra("Password");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateGender() | !validateNumber())
                {
                    return;
                }
                selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
                String _gender = selectedGender.getText().toString();
                String _number = phoneNumber.getEditText().getText().toString();
                String Phone = "+" + selectedCode.getFullNumber() + _number;
                Intent intent = new Intent(SignInPage2.this,OTPPage.class);
                intent.putExtra("Name",name);
                intent.putExtra("Username",username);
                intent.putExtra("EmailID",email);
                intent.putExtra("Password",password);
                intent.putExtra("Gender",_gender);
                intent.putExtra("PhoneNumber",Phone);
                startActivity(intent);
            }
        });

    }
    public void openSignInScreen1(View view) {
        Intent intent = new Intent(SignInPage2.this, SignInPage1.class);
        startActivity(intent);
        finish();
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateNumber(){
        String val = phoneNumber.getEditText().getText().toString();
        if(val.isEmpty()){
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            phoneNumber.setError(null);
            return true;
        }
    }
}