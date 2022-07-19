package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class PuneTemples extends AppCompatActivity {

    private Button dagdusheth, pataleshwar, iscon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pune_temples);

        dagdusheth = findViewById(R.id.dagdusheth_butn);
        pataleshwar = findViewById(R.id.pataleswar_butn);
        iscon = findViewById(R.id.isconTemple_butn);

        dagdusheth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneTemples.this, Dagadusheth.class);
                startActivity(intent);
            }
        });

        pataleshwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneTemples.this, Pataleshwar.class);
                startActivity(intent);
            }
        });

        iscon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneTemples.this, Iscontemple.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelector(View view) {
        Intent intent = new Intent(PuneTemples.this, PlaceSelector.class);
        startActivity(intent);
    }
}