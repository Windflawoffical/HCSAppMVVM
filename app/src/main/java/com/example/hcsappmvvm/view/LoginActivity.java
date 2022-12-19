package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcsappmvvm.interfaces.AuthListener;
import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityLoginBinding;
import com.example.hcsappmvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements AuthListener {

    ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginBinding.setLoginviewmodel(loginViewModel);
        loginViewModel.authListener = this;

        loginBinding.staff.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginForStaff.class);
            startActivity(intent);
        });
        loginBinding.VK.setOnClickListener(view -> {
            Intent intent = new Intent(this, OAuth_VK.class);
            startActivity(intent);
        });
    }


    @Override
    public void onSuccess() {
        Intent userintent = new Intent(this, HomeActivity.class);
        userintent.putExtra("Who's come", "User");
        startActivity(userintent);
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onTextClick(View view){
        TextView textView = (TextView)findViewById(R.id.signup);
        textView.setOnClickListener(view1 -> {
            Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
            startActivity(intent);
        });
    }


}