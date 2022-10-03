package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.ProfileListener;

public class ChangeDataHelperViewModel extends ViewModel {

    public ProfileListener profileListener = null;

    public void onSaveButtonClick(View view){
        profileListener.ChangeData();
    }
}
