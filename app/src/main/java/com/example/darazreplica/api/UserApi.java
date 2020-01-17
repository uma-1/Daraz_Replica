package com.example.darazreplica.api;

import com.example.darazreplica.model.User;
import com.example.darazreplica.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/signup")
    Call<SignUpResponse> registerUser(@Body User users);

    @POST("user/login")
    Call<SignUpResponse> checkUser(@Body User users);
}
