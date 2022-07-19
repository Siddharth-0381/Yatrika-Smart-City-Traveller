package LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class MumbaiHistoricals extends AppCompatActivity {

    private Button gateway, elephanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mumbai_historicals);

        gateway = findViewById(R.id.gateway_butn);
        elephanta = findViewById(R.id.elephenta_butn);

        gateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiHistoricals.this, GateWayOfIndia.class);
                startActivity(intent);
            }
        });

        elephanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MumbaiHistoricals.this, ElephantaCaves.class);
                startActivity(intent);
            }
        });
    }

    public void openPlaceSelectorM(View view) {
        Intent intent = new Intent(MumbaiHistoricals.this, PlaceSelector.class);
        startActivity(intent);
    }
}