package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class ShaniwarWada extends AppCompatActivity {

    private Button shaniwarTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shaniwar_wada);

        shaniwarTrip = findViewById(R.id.shaniwarTrip);

        shaniwarTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Shaniwar Wada, Pune";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openPuneHistoricals(View view) {
        Intent intent  = new Intent(ShaniwarWada.this, PuneHistoricals.class);
        startActivity(intent);
    }
}