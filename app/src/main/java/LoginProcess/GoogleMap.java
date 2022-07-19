package LoginProcess;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.yatrika_travel.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    com.google.android.gms.maps.GoogleMap mapAPI;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);


        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng Maharashtra = new LatLng(19.528419737461753, 75.54142138788069);

        mapAPI.addMarker(new MarkerOptions().position(Maharashtra).title("Maharashtra"));

        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(Maharashtra));
    }
}