package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class GateWayOfIndia extends AppCompatActivity {
    private Button gatewayTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gate_way_of_india);

        gatewayTrip = findViewById(R.id.gatewayTrip);

        gatewayTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "GateWay Of india, Mumbai";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openMumabiHistoricals(View view) {
        Intent intent = new Intent(GateWayOfIndia.this, MumbaiHistoricals.class);
        startActivity(intent);
    }
}