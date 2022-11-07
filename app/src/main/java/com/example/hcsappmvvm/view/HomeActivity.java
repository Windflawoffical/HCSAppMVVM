package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityHomeBinding;
import com.example.hcsappmvvm.interfaces.HomeListener;
import com.example.hcsappmvvm.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity implements HomeListener {

    ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeBinding.setHomeviewmodel(homeViewModel);
        homeViewModel.homeListener = this;
    }


    @Override
    public void onAppeals() {
        Intent appealsintent = new Intent(this, AppealsActivity.class);
        startActivity(appealsintent);
    }
}