package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class Mahalaxmi extends AppCompatActivity {

    private Button mahalaxmiTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahalaxmi);

        mahalaxmiTrip = findViewById(R.id.mahalaxmiTrip);

        mahalaxmiTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Mahalaxmi Mandir, Mumbai";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openMumbaiTemples(View view) {
        Intent intent = new Intent(Mahalaxmi.this, MumbaiTemples.class);
        startActivity(intent);
    }
}