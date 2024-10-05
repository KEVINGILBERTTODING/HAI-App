package com.example.hai.features.dashboard.user.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hai.R;
import com.example.hai.databinding.FragmentUserDashboardBinding;
import com.example.hai.utils.Constans;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserDashboardFragment extends Fragment {
    private FragmentUserDashboardBinding binding;
    private SharedPreferences sharedPreferences;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences(Constans.SHARED_PREF_KEY, Context.MODE_PRIVATE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserDashboardBinding.inflate(inflater, container, false);

        initUi();

        return binding.getRoot();
    }

    private void initUi() {
        binding.tvUsername.setText("Hai, " + sharedPreferences.getString(Constans.NAME, ""));


    }
}