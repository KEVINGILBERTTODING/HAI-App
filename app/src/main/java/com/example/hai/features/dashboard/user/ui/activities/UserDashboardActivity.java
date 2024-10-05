package com.example.hai.features.dashboard.user.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.hai.R;
import com.example.hai.features.dashboard.user.ui.fragments.UserDashboardFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserDashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentTransaction(new UserDashboardFragment());

        setContentView(R.layout.activity_user_dashboard);

    }

    private void fragmentTransaction(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameUserHome, fragment)
                .commit();
    }
}