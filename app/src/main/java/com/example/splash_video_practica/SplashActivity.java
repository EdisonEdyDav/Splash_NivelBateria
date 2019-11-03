package com.example.splash_video_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.splash_video_practica.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {


    private final int DURACION_SPLASH=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent (SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            };
        },DURACION_SPLASH);
    }
}
