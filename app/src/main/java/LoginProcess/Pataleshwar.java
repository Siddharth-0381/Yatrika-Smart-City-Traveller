package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class Pataleshwar extends AppCompatActivity {

    private Button pataleshwarTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pataleshwar);

        pataleshwarTrip = findViewById(R.id.pataleshwarTrip);

        pataleshwarTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Pataleshwar Mandir, Pune";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openPuneTemples(View view) {

        Intent intent = new Intent(Pataleshwar.this, PuneTemples.class);
        startActivity(intent);
    }
}