package co.asynclabs.ahuskano.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        setup();
    }

    protected void setup() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), getNext());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    protected int getLayout() {
        return R.layout.activity_splash;
    }

    protected Class getNext() {
        if (true) {
            return LoginActivity.class;
        }

        return DashboardActivity.class;
    }
}
