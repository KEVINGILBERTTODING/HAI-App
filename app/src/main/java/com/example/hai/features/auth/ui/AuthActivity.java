package com.example.hai.features.auth.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.hai.R;
import com.example.hai.databinding.ActivityAuthBinding;
import com.example.hai.features.auth.ui.fragments.UserLoginFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AuthActivity extends AppCompatActivity {
    private ActivityAuthBinding activityAuthBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the binding object
        activityAuthBinding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(activityAuthBinding.getRoot());

        fragmentTransaction(new UserLoginFragment());



    }



    private void fragmentTransaction(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameAuth, fragment)
                .commit();
    }
}