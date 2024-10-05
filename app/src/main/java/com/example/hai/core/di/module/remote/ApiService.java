package com.example.hai.core.di.module.remote;

import com.example.hai.core.data.models.ResponseApiModel;
import com.example.hai.features.user.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    public static final String IP_ADDRESS = "192.168.35.215";
    public static final String BASE_URL = "http://" + IP_ADDRESS + ":8000/api/";


    @FormUrlEncoded
    @POST("auth")
    Call<ResponseApiModel<UserModel>> userLogin(
            @Field("nrp") String nrp,
            @Field("password") String password
    );
}
