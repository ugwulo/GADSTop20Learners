package com.example.gadstop20learners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gadstop20learners.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private static boolean isSplashLoaded = true;
    ActivitySplashBinding mSplashBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashBinding = ActivitySplashBinding.inflate(getLayoutInflater());


        if (isSplashLoaded) {
            setContentView(mSplashBinding.getRoot());
            int secondsDelayed = 1;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);

            isSplashLoaded = true;
        }
        else {
            Intent goToMainActivity = new Intent(SplashActivity.this, MainActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }
    }
}