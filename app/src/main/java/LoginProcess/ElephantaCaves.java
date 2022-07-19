package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class ElephantaCaves extends AppCompatActivity {

    private Button elephantaTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elephanta_caves);

        elephantaTrip = findViewById(R.id.elephantaTrip);

        elephantaTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Elephanta Caves, Mumbai";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openMumabiHistoricals(View view) {
        Intent intent = new Intent(ElephantaCaves.this, MumbaiHistoricals.class);
        startActivity(intent);
    }
}