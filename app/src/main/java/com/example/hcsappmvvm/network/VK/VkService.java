package com.example.hcsappmvvm.network.VK;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface VkService {
    @GET("account.getProfileInfo")
    Call<VkResponse> getPersonInfo(@Query("v") String version,
                                   @Query("access_token") String token,
                                    @Query("user_id") String userId);
}
