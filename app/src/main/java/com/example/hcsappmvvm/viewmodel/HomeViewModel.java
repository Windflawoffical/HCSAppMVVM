package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.HomeListener;

public class HomeViewModel extends ViewModel {

    public HomeListener homeListener = null;

    public void onAppealsButtonClick(View view){
        homeListener.onAppeals();

    }
}
