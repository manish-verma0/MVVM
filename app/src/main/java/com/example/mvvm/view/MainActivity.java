package com.example.mvvm.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.viewmodel.DaggerViewModelFactory;
import com.example.mvvm.viewmodel.LoginViewModel;


import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    @Inject
    DaggerViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        loginViewModel = new ViewModelProvider(this,viewModelFactory).get(LoginViewModel.class);
        activityMainBinding.setViewModel(loginViewModel);
        activityMainBinding.setLifecycleOwner(this);

        loginViewModel.getUser().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                Toast.makeText(MainActivity.this,""+message,Toast.LENGTH_LONG).show();
            }
        });



        /*loginViewModel.getUser2().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user!=null){
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                }
            }
        });*/
}}