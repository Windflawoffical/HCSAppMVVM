package com.example.hcsappmvvm.viewmodel;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatCallback;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.hcsappmvvm.AuthListener;
import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityLoginBinding;


public class LoginViewModel extends ViewModel  {

    public String email = "";
    public String password = "";
    public AuthListener authListener = null;

    public void onLoginButtonClick(View view){
        authListener.onStarted();
        if(email.isEmpty() || password.isEmpty()){
            //failure
            authListener.onFailure("Invalid email or password");
            return;
        }
        //success
        authListener.onSuccess();
    }

}
