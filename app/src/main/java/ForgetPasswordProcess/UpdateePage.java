package ForgetPasswordProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yatrika_travel.R;

import Common.LoginScreen;

public class UpdateePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatee_page);
    }

    public void openLoginPage(View view) {
        Intent intent = new Intent(UpdateePage.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }
}