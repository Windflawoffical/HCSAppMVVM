package com.example.hcsappmvvm.viewmodel;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
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
        if(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() > 5){
            //success
            authListener.onSuccess();
            return;
        }
        //failure
        authListener.onFailure("Invalid email or password");
    }

}
