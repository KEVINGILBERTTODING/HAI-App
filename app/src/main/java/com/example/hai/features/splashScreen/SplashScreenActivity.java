package com.example.hai.features.splashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.hai.R;
import com.example.hai.features.auth.ui.AuthActivity;
import com.example.hai.features.dashboard.user.ui.activities.UserDashboardActivity;
import com.example.hai.utils.Constans;

public class SplashScreenActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(Constans.SHARED_PREF_KEY, MODE_PRIVATE);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                authValidate();
            }
        }, 3000L);




        setContentView(R.layout.activity_splash_screen);



    }

    private void authValidate() {
        if (sharedPreferences.getBoolean(Constans.IS_LOGIN, false) == true) {
            startActivity(new Intent(SplashScreenActivity.this, UserDashboardActivity.class));
            finish();
        }else {
            startActivity(new Intent(SplashScreenActivity.this, AuthActivity.class));
            finish();
        }
    }


}