package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

import Common.LoginScreen;

public class HomePage extends AppCompatActivity {

    String fullname;
    TextView namefield;
    private Button planTripbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        namefield = findViewById(R.id.name);
        planTripbtn = findViewById(R.id.plan_a_trip_btn);
        fullname = getIntent().getStringExtra("fullname");
        namefield.setText(fullname);


        planTripbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, CitySelector.class);
                startActivity(intent);
            }
        });

    }
    public void openTranslator(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://translate.google.co.in/"));
        startActivity(intent);
    }

    public void openLoginScreen(View view) {
        Intent intent = new Intent(HomePage.this, LoginScreen.class);
        startActivity(intent);
        finish();
    }


}