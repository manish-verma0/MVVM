package com.example.mvvm.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.mvvm.di.ViewModelKey;
import com.example.mvvm.viewmodel.DaggerViewModelFactory;
import com.example.mvvm.viewmodel.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindViewModel(LoginViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(DaggerViewModelFactory factory);

}