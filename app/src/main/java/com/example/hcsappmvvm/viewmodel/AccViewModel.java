package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.ProfileListener;

public class AccViewModel extends ViewModel {
    public ProfileListener profileListener = null;

    public void onChangeDataButtonClicked(View view){
        profileListener.ChangeData();
    }
}
