package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class PuneHistoricals extends AppCompatActivity {

    private Button sinhagad, shanirvarWada, agaKhanPalace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pune_historicals);

        sinhagad = findViewById(R.id.sinhagad_butn);
        shanirvarWada = findViewById(R.id.shanivar_butn);
        agaKhanPalace = findViewById(R.id.agaKhanPalace_butn);

        sinhagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PuneHistoricals.this, Sinhagad.class);
                startActivity(intent);
            }
        });

        shanirvarWada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneHistoricals.this, ShaniwarWada.class);
                startActivity(intent);
            }
        });

        agaKhanPalace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneHistoricals.this, AgaKhanPalace.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelectorP(View view) {
        Intent intent = new Intent(PuneHistoricals.this, PlaceSelector.class);
        startActivity(intent);
    }
}