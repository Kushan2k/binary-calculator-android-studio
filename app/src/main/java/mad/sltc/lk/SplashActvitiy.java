package mad.sltc.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class SplashActvitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actvitiy);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        long delay=1000;



        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActvitiy.this,RegisterActivity.class));
                SplashActvitiy.this.finish();
            }
        },delay);

    }
}