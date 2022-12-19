package com.example.hcsappmvvm.network.VK;

import com.google.gson.annotations.SerializedName;

public class VkResponse {
    public static class User {
        @SerializedName("first_name")
        public String firstname;
        @SerializedName("last_name")
        public String lastname;

        public String userId;
        public String access_token;

        public User(String access_token, String userId){
            this.access_token = access_token;
            this.userId = userId;
        }
    }
    public User response;
}
