package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hcsappmvvm.interfaces.AuthListener;
import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivitySignupBinding;
import com.example.hcsappmvvm.viewmodel.SignUpViewModel;

public class SignupActivity extends AppCompatActivity implements AuthListener {

    ActivitySignupBinding signupBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signupBinding = DataBindingUtil.setContentView(this,R.layout.activity_signup);
        SignUpViewModel viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        signupBinding.setSignupviewmodel(viewModel);
        viewModel.authListener = this;
    }

    @Override
    public void onStarted() {
        Toast.makeText(this, "Registration Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}