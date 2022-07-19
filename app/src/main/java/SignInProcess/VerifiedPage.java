package SignInProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yatrika_travel.R;

import Common.LoginScreen;

public class VerifiedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verified_page);



    }

    public void openLoginScreen(View view) {
        Intent intent = new Intent(VerifiedPage.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }

}