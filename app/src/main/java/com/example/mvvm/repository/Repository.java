package com.example.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.model.ResponseModel;
import com.example.mvvm.model.User;
import com.example.mvvm.network.LoginApi;




import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;



public class Repository {


    private static LoginApi api;

    @Inject
    public Repository(LoginApi loginApi) {
        this.api=loginApi;
    }



    public static MutableLiveData<String> checkLogin(final User loginRequestModel) {
        final MutableLiveData<String> data = new MutableLiveData<>();

        api.checkLogin(loginRequestModel).subscribeWith(new DisposableSingleObserver<ResponseModel>() {
            @Override
            public void onSuccess(@NonNull ResponseModel responseModel) {
                data.setValue(responseModel.getMessage().toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                data.setValue(e.getMessage());
            }
        });
        /*api.checkLogin(loginRequestModel)
                .enqueue(new Callback<ResponseModel>() {

                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()){
                            data.setValue(response.body().getMessage().toString());
                        }
                        else {
                            data.setValue(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        data.setValue(t.getMessage());
                    }
                });*/
        return data;
    }

}
