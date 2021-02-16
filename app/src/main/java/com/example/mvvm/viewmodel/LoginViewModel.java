package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mvvm.model.User;
import com.example.mvvm.repository.Repository;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> PhoneNumber = new MutableLiveData<>();
    public MutableLiveData<String> Country = new MutableLiveData<>();
    private MutableLiveData<String> loginResponseModelMutableLiveData;
    Map<String, String> params = new HashMap<>();
    Repository userRepository;

    @Inject
    public LoginViewModel(Repository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkLogin(User loginRequestModel) {
        loginResponseModelMutableLiveData = Repository.checkLogin(loginRequestModel);
    }

    /*public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }*/

    public LiveData<String> getUser() {
        if (loginResponseModelMutableLiveData == null) {
            loginResponseModelMutableLiveData = new MutableLiveData<>();
        }

        return loginResponseModelMutableLiveData;
    }

    public void onLoginClick() {
        User loginRequestModel = new User(Country.getValue(), PhoneNumber.getValue());
        loginRequestModel.setCountryCode(Country.getValue());
        loginRequestModel.setMobileNumber(PhoneNumber.getValue());
        checkLogin(loginRequestModel);
    }

    /*public void onClick() {

        User loginUser = new User(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(loginUser);

    }*/
}
