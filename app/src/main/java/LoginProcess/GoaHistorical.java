package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class GoaHistorical extends AppCompatActivity {

    private Button Basilica, Aguada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goa_historical);

        Basilica = findViewById(R.id.basilica_butn);
        Aguada = findViewById(R.id.Agvada_butn);


        Basilica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoaHistorical.this, BasilicaChurch.class);
                startActivity(intent);
            }
        });

        Aguada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoaHistorical.this, AguadaFort.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelectorP(View view) {
        Intent intent = new Intent(GoaHistorical.this, PlaceSelector.class);
        startActivity(intent);
    }
}