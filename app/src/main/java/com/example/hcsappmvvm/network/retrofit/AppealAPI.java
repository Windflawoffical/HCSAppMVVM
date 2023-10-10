package com.example.hcsappmvvm.network.retrofit;

import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppealAPI {

    @GET("/appeal/get-all")
    Call<List<Appeal>> getAllAppeals();

    @POST("/appeal/save-appeal")
    Call<Appeal> saveAppeal(@Body Appeal appeal);

}
