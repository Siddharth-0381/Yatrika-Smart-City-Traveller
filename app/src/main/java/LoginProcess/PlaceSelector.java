package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class PlaceSelector extends AppCompatActivity {

    private Button historicals, temples, amusmentparks;
    String City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_selector);

        City = getIntent().getStringExtra("CitySelected").toString();

        historicals = findViewById(R.id.historical_butn);
        temples = findViewById(R.id.temple_butn);
        amusmentparks = findViewById(R.id.waterPark_butn);


        historicals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (City.equals("Pune")) {
                    Intent intent = new Intent(PlaceSelector.this, PuneHistoricals.class);
                    intent.putExtra("CitySelected", "Pune");
                    startActivity(intent);
                } else if (City.equals("Mumbai")) {
                    Intent intent = new Intent(PlaceSelector.this, MumbaiHistoricals.class);
                    intent.putExtra("CitySelected", "Mumbai");
                    startActivity(intent);
                } else if (City.equals("Goa")) {
                    Intent intent = new Intent(PlaceSelector.this, GoaHistorical.class);
                    startActivity(intent);
                }
            }
        });

        temples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (City.equals("Pune")) {
                    Intent intent = new Intent(PlaceSelector.this, PuneTemples.class);
                    intent.putExtra("CitySelected", "Pune");
                    startActivity(intent);
                } else if (City.equals("Mumbai")) {
                    Intent intent = new Intent(PlaceSelector.this, MumbaiTemples.class);
                    intent.putExtra("CitySelected", "Mumbai");
                    startActivity(intent);
                }
            }
        });

        amusmentparks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (City.equals("Pune")) {
                    Intent intent = new Intent(PlaceSelector.this, PuneAmusement.class);
                    intent.putExtra("CitySelected", "Pune");
                    startActivity(intent);
                } else if (City.equals("Mumbai")) {
                    Intent intent = new Intent(PlaceSelector.this, NoData.class);
                    startActivity(intent);
                } else if (City.equals("Goa")) {
                    Intent intent = new Intent(PlaceSelector.this, NoData.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void openCitySelector(View view) {
        Intent intent = new Intent(PlaceSelector.this, CitySelector.class);
        startActivity(intent);
    }
}