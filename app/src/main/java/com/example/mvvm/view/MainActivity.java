package com.example.mvvm.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.model.User;
import com.example.mvvm.viewmodel.LoginViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        loginViewModel =new ViewModelProvider(this).get(LoginViewModel.class);
        activityMainBinding.setViewModel(loginViewModel);
        activityMainBinding.setLifecycleOwner(this);

        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getEmail())) {
                    activityMainBinding.emailET.setError("Enter an E-Mail Address");
                    activityMainBinding.emailET.requestFocus();
                }
                else if (!loginUser.isEmailValid()) {
                    activityMainBinding.emailET.setError("Enter a Valid E-mail Address");
                    activityMainBinding.emailET.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())) {
                    activityMainBinding.emailET.setError("Enter a Password");
                    activityMainBinding.emailET.requestFocus();
                }
                else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    activityMainBinding.passwordET.setError("Enter at least 6 Digit password");
                    activityMainBinding.passwordET.requestFocus();
                }
                else {
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_LONG).show();
                }

            }
        });

        loginViewModel.getUser2().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user!=null){
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                }
            }
        });
}}