package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        Intent intent = getIntent();
        String whoscome = intent.getStringExtra("Who's come");
        if(whoscome.equals("User")) {
            homeBinding.addappeal.setVisibility(View.VISIBLE);
            //homeBinding.checkappeals.setVisibility(View.GONE);
            //homeBinding.ban.setVisibility(View.GONE);
        } else if (whoscome.equals("Moderator")) {
            //homeBinding.addappeal.setVisibility(View.GONE);
            homeBinding.checkappeals.setVisibility(View.VISIBLE);
            //homeBinding.ban.setVisibility(View.GONE);
        } else if (whoscome.equals("Administrator")) {
            //homeBinding.addappeal.setVisibility(View.GONE);
            //homeBinding.checkappeals.setVisibility(View.GONE);
            homeBinding.ban.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onAddAppeal() {
        Intent addappealintent = new Intent(this, AddAppealActivity.class);
        startActivity(addappealintent);
    }

    @Override
    public void onCheckAppeals() {
        Intent oncheckappealsintent = new Intent(this, AppealsActivity.class);
        startActivity(oncheckappealsintent);
    }

    @Override
    public void onAddNewModer() {
        Intent intent = new Intent(this, AddNewModer.class);
        startActivity(intent);

    }

}