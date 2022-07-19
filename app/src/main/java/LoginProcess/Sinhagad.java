package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class Sinhagad extends AppCompatActivity {

    Button planTrip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinhagad);

        planTrip = findViewById(R.id.sinhagadTrip);


        planTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Destination = "Sinhagad Fort, Pune";
                DisplayTrack(Destination);
            }
        });

    }

    private void DisplayTrack(String destination) {


        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/maps/dir//" + destination));
        Intent chooser = Intent.createChooser(intent,"Launch Maps");
        startActivity(chooser);

    }

    public void openPuneHistoricals(View view) {
        Intent intent = new Intent(Sinhagad.this, PuneHistoricals.class);
        startActivity(intent);
    }
}