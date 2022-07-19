package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class BasilicaChurch extends AppCompatActivity {

    private Button basilicaTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basilica_church);

        basilicaTrip = findViewById(R.id.basilicaTrip);

        basilicaTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Basilica of bom Jesus, Goa";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openGoaHistoricals(View view) {
        Intent intent = new Intent(BasilicaChurch.this, GoaHistorical.class);
        startActivity(intent);
    }
}