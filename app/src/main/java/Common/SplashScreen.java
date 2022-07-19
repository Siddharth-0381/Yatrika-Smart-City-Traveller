package Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.yatrika_travel.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    //Variables
    ImageView imageView;

    //animation
    Animation sideAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //Hooks
        imageView = findViewById(R.id.splashscreen);
        //Animation
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);

        //set Animation
        imageView.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}