package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityLoginForStaffBinding;
import com.example.hcsappmvvm.interfaces.AuthListener;
import com.example.hcsappmvvm.interfaces.AuthStaffListener;
import com.example.hcsappmvvm.viewmodel.LoginForStaffViewModel;

public class LoginForStaff extends AppCompatActivity implements AuthStaffListener {

    ActivityLoginForStaffBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_for_staff);
        LoginForStaffViewModel loginForStaffViewModel = new ViewModelProvider(this).get(LoginForStaffViewModel.class);
        mBinding.setLoginForStaffviewmodel(loginForStaffViewModel);
        loginForStaffViewModel.authStaffListener = this;


    }

    @Override
    public void onSuccessModerator() {
        Intent moderintent = new Intent(this, HomeActivity.class);
        moderintent.putExtra("Who's come", "Moderator");
        startActivity(moderintent);
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSuccessAdministator() {
        Intent adminintent = new Intent(this, HomeActivity.class);
        adminintent.putExtra("Who's come", "Administrator");
        startActivity(adminintent);
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}