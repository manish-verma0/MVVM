package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mvvm.model.User;
import com.example.mvvm.repository.Repository;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    public Repository loginRepo;
    private MutableLiveData<User> userMutableLiveData;
    private MutableLiveData<User> loginResponseModelMutableLiveData;
    Map<String, String> params = new HashMap<>();

    public void checkLogin(User loginRequestModel) {
        loginResponseModelMutableLiveData = Repository.checkLogin(loginRequestModel);
    }

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public LiveData<User> getUser2() {
        if (loginResponseModelMutableLiveData == null) {
            loginResponseModelMutableLiveData = new MutableLiveData<>();
            loginRepo = Repository.getInstance();
        }

        return loginResponseModelMutableLiveData;
    }

    public void onLoginClick() {
        User loginRequestModel = new User(EmailAddress.getValue(), Password.getValue());
        loginRequestModel.setEmail(EmailAddress.getValue());
        loginRequestModel.setPassword(Password.getValue());
        params.put("email", loginRequestModel.getEmail());
        params.put("password", loginRequestModel.getPassword());
        checkLogin(loginRequestModel);
    }

    public void onClick() {

        User loginUser = new User(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(loginUser);

    }
}
