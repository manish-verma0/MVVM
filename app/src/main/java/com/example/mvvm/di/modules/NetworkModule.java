package com.example.mvvm.di.modules;



import com.example.mvvm.network.LoginApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class NetworkModule {

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();


    }

    @Provides
    @Singleton
    static LoginApi provideUserService(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }
}
