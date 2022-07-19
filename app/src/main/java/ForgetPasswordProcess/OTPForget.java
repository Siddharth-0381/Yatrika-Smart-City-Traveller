package ForgetPasswordProcess;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.chaos.view.PinView;
import com.example.yatrika_travel.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

import Common.LoginScreen;
import Database.UserHelperClass;

public class OTPForget extends AppCompatActivity {

    TextView number;
    PinView pinFromUser;
    String codeBySystem;
    String name, username, email, password, gender, numberS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.o_t_p_page);

        number = findViewById(R.id.phoneNumber);
        pinFromUser = findViewById(R.id.pin_view);

        name = getIntent().getStringExtra("Name");
        username = getIntent().getStringExtra("Username");
        email = getIntent().getStringExtra("EmailID");
        password = getIntent().getStringExtra("Password");
        gender = getIntent().getStringExtra("Gender");
        numberS = getIntent().getStringExtra("PhoneNumber");
        number.setText(numberS);
        sendVerificationCodeToUser(numberS);
    }

    private void sendVerificationCodeToUser(String phoneNo) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNo)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if(code!=null)
                    {
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(OTPForget.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem,code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(OTPForget.this,newCredentialsScreen.class);
                            intent.putExtra("phoneNumber",numberS);
                            startActivity(intent);
                            Toast.makeText(OTPForget.this, "Verified!", Toast.LENGTH_SHORT).show();
                        } else {

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(OTPForget.this, "Verification not completed! Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }


    private void storeNewUsersData() {
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        UserHelperClass addNewUser = new UserHelperClass(name, username, email, password, numberS, gender);
        reference.child(numberS).setValue(addNewUser);
    }

    public void openLoginScreen(android.view.View view) {
        Intent intent = new Intent(OTPForget.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }
    public void openVerifiedPage(android.view.View view)
    {
        String code = pinFromUser.getText().toString();
        if(!code.isEmpty())
        {
            verifyCode(code);
        }
    }
}