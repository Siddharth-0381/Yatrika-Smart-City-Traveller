package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class WetAndJoy extends AppCompatActivity {

    private Button WetAndJoyTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wet_and_joy);

        WetAndJoyTrip = findViewById(R.id.WetAndJoyTrip);

        WetAndJoyTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Wet And Joy, Lonavala, Pune";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openPuneHistoricals(View view) {
        Intent intent =new Intent(WetAndJoy.this, PuneAmusement.class);
        startActivity(intent);
    }
}