package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.AuthListener;

public class SignUpViewModel extends ViewModel {

    public String email = "";
    public String password = "";
    public String phone = "";
    public AuthListener authListener = null;

    public void onSignUpButtonClick(View view){
        authListener.onStarted();
        if(email.isEmpty() || password.isEmpty() || phone.isEmpty()){
            //failed
            authListener.onFailure("Invalid email or password");
            return;
        }
        //success
        authListener.onSuccess();
        ifSignUpSuccessfull();
    }

    public void ifSignUpSuccessfull(){
        //
    }

}
