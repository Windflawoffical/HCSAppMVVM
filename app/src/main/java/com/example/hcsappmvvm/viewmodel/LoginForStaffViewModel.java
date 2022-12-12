package com.example.hcsappmvvm.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.AuthStaffListener;
import com.example.hcsappmvvm.view.LoginForStaff;

public class LoginForStaffViewModel extends ViewModel {

    public String ID = "";
    public String password = "";
    public AuthStaffListener authStaffListener = null;

    public void onLoginForStaffButtonClick(View view){
        if(ID.equals("Moder777") && password.length() > 5){
            //success
            authStaffListener.onSuccessModerator();
            return;
        } else if (ID.equals("Admin888") && password.length() > 5) {
            authStaffListener.onSuccessAdministator();
        }
        //failure
        authStaffListener.onFailure("Invalid ID or password");
    }
}
