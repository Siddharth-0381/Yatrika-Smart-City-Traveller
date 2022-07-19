package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class CitySelector extends AppCompatActivity {

    Button pune, mumbai, goa, kolkata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_selector);

        pune = findViewById(R.id.pune_butn);
        mumbai = findViewById(R.id.mumbai_butn);
        goa = findViewById(R.id.goa_butn);

        pune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitySelector.this, PlaceSelector.class);
                intent.putExtra("CitySelected", "Pune");
                startActivity(intent);
            }
        });

        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitySelector.this, PlaceSelector.class);
                intent.putExtra("CitySelected", "Mumbai");
                startActivity(intent);
            }
        });

        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitySelector.this, PlaceSelector.class);
                intent.putExtra("CitySelected", "Goa");
                startActivity(intent);
            }
        });

    }

    public void openHomePage(View view) {

        Intent intent = new Intent(CitySelector.this, HomePage.class);
        startActivity(intent);

    }


}