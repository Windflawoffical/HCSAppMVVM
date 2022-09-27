package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcsappmvvm.AuthListener;
import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityLoginBinding;
import com.example.hcsappmvvm.viewmodel.LoginViewModel;
import com.example.hcsappmvvm.viewmodel.SignUpViewModel;

public class LoginActivity extends AppCompatActivity implements AuthListener {

    ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginBinding.setLoginviewmodel(viewModel);
        viewModel.authListener = this;
    }

    @Override
    public void onStarted() {
        Toast.makeText(this, "Login started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onTextClick(View view){
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });
    }


}