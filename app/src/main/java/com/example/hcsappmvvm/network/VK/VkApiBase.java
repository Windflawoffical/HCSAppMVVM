package com.example.hcsappmvvm.network.VK;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hcsappmvvm.CurrentUser;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VkApiBase {
    private final VkService vkService;
    public VkApiBase(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.vk.com/method/")
                .build();

        vkService = retrofit.create(VkService.class);
    }
    public LiveData<VkResponse> getPersonInfo(){
        MutableLiveData<VkResponse> vkuser = new MutableLiveData<>();
        vkService.getPersonInfo(
                "5.154#",
                CurrentUser.getInstance().access_token,
                CurrentUser.getInstance().userId
        ).enqueue(
                new Callback<VkResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<VkResponse> call, @NonNull Response<VkResponse> response) {
                        if(response.isSuccessful()){
                            //настроить логику получения данных из response
                            vkuser.setValue(response.body());
//                            if (response.body() != null) {
//                                Log.e("RESPONSE", "RESPONSE = " + response.body().response.firstname);
//                            }
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<VkResponse> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
        return vkuser;
    }
}
