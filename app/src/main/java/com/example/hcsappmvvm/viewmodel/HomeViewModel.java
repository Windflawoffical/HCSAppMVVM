package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.HomeListener;

public class HomeViewModel extends ViewModel {

    public HomeListener homeListener = null;

    public void onAddAppealButtonClick(View view){
        homeListener.onAddAppeal();
    }
    public void onCheckAppealsButtonClick(View view){
        homeListener.onCheckAppeals();
    }
    public void onAddModerButtonClick(View view){
        homeListener.onAddNewModer();
    }
}
