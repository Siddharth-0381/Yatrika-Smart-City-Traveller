package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class Siddhivinayak extends AppCompatActivity {
    private Button SiddhivinayakTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siddhivinayak);

        SiddhivinayakTrip = findViewById(R.id.SiddhivinayakTrip);

        SiddhivinayakTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Siddhivinayak Mandir, Mumbai";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openMumbaiTemples(View view) {
        Intent intent = new Intent(Siddhivinayak.this, MumbaiTemples.class);
        startActivity(intent);
    }
}