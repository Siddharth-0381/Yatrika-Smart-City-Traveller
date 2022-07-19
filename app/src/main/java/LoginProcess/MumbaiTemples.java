package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class MumbaiTemples extends AppCompatActivity {

    private Button siddhivinayak, mahalaxmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mumbai_temples);

        siddhivinayak = findViewById(R.id.siddhivinayak_butn);
        mahalaxmi = findViewById(R.id.mahalaxmi_butn);

        siddhivinayak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiTemples.this, Siddhivinayak.class);
                startActivity(intent);
            }
        });

        mahalaxmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiTemples.this, Mahalaxmi.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelector(View view) {
        Intent intent = new Intent(MumbaiTemples.this, PlaceSelector.class);
        startActivity(intent);
    }
}