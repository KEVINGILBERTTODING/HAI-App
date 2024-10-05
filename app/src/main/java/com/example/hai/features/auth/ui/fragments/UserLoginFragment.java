package com.example.hai.features.auth.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hai.R;
import com.example.hai.databinding.FragmentUserLoginBinding;
import com.example.hai.features.auth.viewmodel.UserAuthViewModel;
import com.example.hai.features.dashboard.user.ui.activities.UserDashboardActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserLoginFragment extends Fragment {
    private FragmentUserLoginBinding binding;
    private UserAuthViewModel userAuthViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userAuthViewModel = new ViewModelProvider(this).get(UserAuthViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserLoginBinding.inflate(inflater, container, false);

        observe();
        listener();


        return binding.getRoot();
    }

    private void observe() {
        userAuthViewModel.isLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.btnLogin.setVisibility(View.GONE);
                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.btnLogin.setVisibility(View.VISIBLE);

                }
            }
        });


        userAuthViewModel.isVerified.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    startActivity(new Intent(requireActivity(), UserDashboardActivity.class));
                    requireActivity().finish();
                }
            }
        });


        userAuthViewModel.errorMessage.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!s.isEmpty()) Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void listener() {
        binding.btnLogin.setOnClickListener(v -> {
            String nrp = binding.etNrp.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (nrp.isEmpty()) {
                Toast.makeText(requireContext(), "NRP tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.isEmpty()) {
                Toast.makeText(requireContext(), "Kata sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            login(nrp, password);


        });
    }

    private void login(String nrp, String password) {
        userAuthViewModel.login(nrp, password);
    }
}