package com.example.mvvm.model;

import android.util.Patterns;

public class User {

    private String countryCode;
    private String mobileNumber;

    public User(String countryCode, String mobileNumber) {
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



    public boolean isPhoneNumberEmpty() {
        return getMobileNumber().length() > 0;
    }
}
