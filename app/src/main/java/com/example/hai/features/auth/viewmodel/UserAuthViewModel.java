package com.example.hai.features.auth.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.hai.core.data.models.ResponseApiModel;
import com.example.hai.core.di.module.remote.ApiService;
import com.example.hai.features.user.models.UserModel;
import com.example.hai.utils.Constans;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class UserAuthViewModel extends AndroidViewModel {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ApiService apiService;
    private String TAG = UserAuthViewModel.class.getSimpleName();
    private Context context;

    @Inject
    public UserAuthViewModel(@NonNull Application application, ApiService apiService) {
        super(application);
        sharedPreferences = getApplication().getSharedPreferences(Constans.SHARED_PREF_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        this.apiService = apiService;
        this.context = application.getApplicationContext();
    }
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<UserModel> userModel = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isVerified = new MutableLiveData<>(false);


    public void login(String nrp, String password) {
        isLoading.postValue(true);
        apiService.userLogin(nrp, password).enqueue(new Callback<ResponseApiModel<UserModel>>() {
            @Override
            public void onResponse(Call<ResponseApiModel<UserModel>> call, Response<ResponseApiModel<UserModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus() == 200) {
                        UserModel userModel1 = response.body().getData();
                        editor.putBoolean(Constans.IS_LOGIN, true);
                        editor.putInt(Constans.USER_ID, userModel1.getUser_id());
                        editor.putString(Constans.NAME, userModel1.getName());
                        editor.putString(Constans.NRP, userModel1.getNrp());
                        editor.putString(Constans.ROLE, userModel1.getRole());
                        editor.putInt(Constans.BIDANG_ID, userModel1.getBidang_id());
                        editor.apply();
                        isVerified.postValue(true);



                    }else  if (response.body().getStatus() == 401) {
                        errorMessage.postValue(response.body().getMessage());

                    }else {
                        errorMessage.postValue(Constans.INTERNAL_SERVER_ERROR);
                    }
                }

                isLoading.postValue(false);

            }

            @Override
            public void onFailure(Call<ResponseApiModel<UserModel>> call, Throwable t) {
                isLoading.postValue(false);
                errorMessage.postValue(Constans.INTERNAL_SERVER_ERROR);
                Log.d(TAG, "onFailure: " + t.getMessage());


            }
        });


    }
}
