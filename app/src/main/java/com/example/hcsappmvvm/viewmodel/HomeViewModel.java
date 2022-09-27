package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.HomeListener;

public class HomeViewModel extends ViewModel {

    public HomeListener homeListener = null;

    public void onAccButtonClick(View view){
        homeListener.onAcc();
    }
    public void onCountersButtonClick(View view){
        homeListener.onCounters();
    }
    public void onAppealsButtonClick(View view){
        homeListener.onAppeals();

    }
}
