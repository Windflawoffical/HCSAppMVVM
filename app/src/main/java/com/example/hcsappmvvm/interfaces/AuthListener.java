package com.example.hcsappmvvm.interfaces;

public interface AuthListener {
    void onStarted();
    void onSuccess();
    void onFailure(String message);

}
