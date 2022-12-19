package com.example.hcsappmvvm;

public class CurrentUser {
    private static CurrentUser instance;
    public String access_token;
    public String userId;


    CurrentUser(){}

    public static CurrentUser getInstance() {
        if (instance == null){
            instance = new CurrentUser();
        }
        return instance;
    }
}
