package com.example.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.model.User;
import com.example.mvvm.network.LoginApi;
import com.example.mvvm.network.RetrofitClientInstance;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {


    private static LoginApi api;
    private static final Repository ourInstance = new Repository();

    public Repository() {
        api = RetrofitClientInstance.getRetrofitInstance().create(LoginApi.class);
    }

    public static MutableLiveData<User> checkLogin(User loginRequestModel) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        Map<String, String> params = new HashMap<>();
        params.put("email", loginRequestModel.getEmail());
        params.put("password", loginRequestModel.getPassword());
        api.checkLogin(params)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public static Repository getInstance() {
        return ourInstance;
    }
}
