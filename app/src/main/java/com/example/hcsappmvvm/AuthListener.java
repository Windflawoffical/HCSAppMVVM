package com.example.hcsappmvvm;

public interface AuthListener {
    void onStarted();
    void onSuccess();
    void onFailure(String message);

}
