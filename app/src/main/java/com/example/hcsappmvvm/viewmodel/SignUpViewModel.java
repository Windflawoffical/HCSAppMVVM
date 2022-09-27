package com.example.hcsappmvvm.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.AuthListener;

public class SignUpViewModel extends ViewModel {

    public String email = "";
    public String password = "";
    public String phone = "";
    public AuthListener authListener = null;


    public void onSignUpButtonClick(View view){
        if(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && password.length() > 5 && phone.length() == 12){
            //success
            authListener.onSuccess();
            return;
        }
            //failure
            authListener.onFailure("Invalid email or password");
        }
}

