package com.example.mvvm.network;

import com.example.mvvm.model.User;

import java.util.Map;

import retrofit2.Call;

public interface LoginApi {


    Call<User> checkLogin(Map<String, String> params);
}
