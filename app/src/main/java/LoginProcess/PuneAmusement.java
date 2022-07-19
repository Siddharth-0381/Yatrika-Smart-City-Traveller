package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class PuneAmusement extends AppCompatActivity {

    private Button phoenix,seasons,wetandjoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pune_amusement);

        phoenix=findViewById(R.id.phoenix_butn);
        seasons=findViewById(R.id.seasons_butn);
        wetandjoy=findViewById(R.id.wetandjoy_butn);

        phoenix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneAmusement.this, Phoenix.class);
                startActivity(intent);
            }
        });

        seasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneAmusement.this, SeasonsMall.class);
                startActivity(intent);
            }
        });

        wetandjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneAmusement.this, WetAndJoy.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelectorP(View view) {
        Intent intent = new Intent(PuneAmusement.this, PlaceSelector.class);
        startActivity(intent);
    }
}