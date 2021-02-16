package com.example.mvvm.network;

import com.example.mvvm.model.ResponseModel;
import com.example.mvvm.model.User;


import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApi {

    @Headers({
            "Content-Type: application/json",
            "DEVICE_ID: 11",
            "Accept-Language: EN",
            "DEVICE_TYPE: Android",
            "COUNTRY: INDIA",
            "CITY: BANGALORE",
            "APP_VERSION: 1.4.2"
    })
    @POST("api/ns/customer/v2/verification")
    Single<ResponseModel> checkLogin(@Body User user);
}
