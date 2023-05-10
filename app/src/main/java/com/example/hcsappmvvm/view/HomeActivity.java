package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityHomeBinding;
import com.example.hcsappmvvm.interfaces.HomeListener;
import com.example.hcsappmvvm.network.VK.VkResponse;
import com.example.hcsappmvvm.viewmodel.HomeViewModel;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity implements HomeListener {

    TextView first_name, last_name;
    ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeBinding.setHomeviewmodel(homeViewModel);
        homeViewModel.homeListener = this;

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);

        Intent intent = getIntent();
        String whoscome = intent.getStringExtra("Who's come");
        String prishlo = intent.getStringExtra("User");
        VkResponse user = new Gson().fromJson(prishlo, VkResponse.class);
        //Log.e("NEED TO CHECK USER", "USER FIRST_NAME = " + user.response.firstname);
        if(whoscome.equals("User")) {
            homeBinding.addappeal.setVisibility(View.VISIBLE);
            homeBinding.checkappeals.setVisibility(View.VISIBLE);
            //homeBinding.ban.setVisibility(View.GONE);
            if(user != null){
                homeBinding.firstName.setText(user.response.firstname);

                homeBinding.lastName.setText(user.response.lastname);
            } else {
                homeBinding.firstName.setText("Simple");
                homeBinding.lastName.setText("User");
            }

        } else if (whoscome.equals("Moderator")) {
            //homeBinding.addappeal.setVisibility(View.GONE);
            homeBinding.checkappeals.setVisibility(View.VISIBLE);
            //homeBinding.ban.setVisibility(View.GONE);
            homeBinding.firstName.setText("Main");
            homeBinding.lastName.setText("Moderator");
        } else if (whoscome.equals("Administrator")) {
            //homeBinding.addappeal.setVisibility(View.GONE);
            //homeBinding.checkappeals.setVisibility(View.GONE);
            homeBinding.ban.setVisibility(View.VISIBLE);
            homeBinding.firstName.setText("Main");
            homeBinding.lastName.setText("Administrator");
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