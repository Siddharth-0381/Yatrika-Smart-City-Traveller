package LoginProcess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatrika_travel.R;

public class AguadaFort extends AppCompatActivity {

    private Button aguadaTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aguada_fort);

        aguadaTrip = findViewById(R.id.aguadaTrip);

        aguadaTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Destination = "Aguada Fort, Goa";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/dir//" + Destination));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void openGoaHistoricals(View view) {
        Intent intent = new Intent(AguadaFort.this, GoaHistorical.class);
        startActivity(intent);
    }
}