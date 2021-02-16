package com.example.mvvm.di.component;




import com.example.mvvm.di.modules.ContextModule;
import com.example.mvvm.di.modules.NetworkModule;
import com.example.mvvm.di.modules.ViewModelModule;
import com.example.mvvm.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class, ViewModelModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}

