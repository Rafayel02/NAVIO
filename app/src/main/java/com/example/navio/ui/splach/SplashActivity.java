package com.example.navio.ui.splach;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.navio.R;
import com.example.navio.backend.local_storage.LocalStorage;
import com.example.navio.ui.lets_start.LetsStartActivity;
import com.example.navio.ui.login.LoginActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Context context = this;
        new Handler().postDelayed(() -> {
            boolean letsStartExecuted = LocalStorage.getInstance()
                    .setContext(this)
                    .setMode(MODE_PRIVATE)
                    .setKey(getString(R.string.local_lets_start))
                    .getBoolean(getString(R.string.local_executed));

            final Intent intent;
            if (letsStartExecuted) intent = new Intent(context, LoginActivity.class);
            else intent = new Intent(context, LetsStartActivity.class);

            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, 500);
    }

}