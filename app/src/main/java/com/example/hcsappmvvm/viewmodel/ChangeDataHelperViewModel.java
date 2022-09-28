package com.example.hcsappmvvm.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.interfaces.RepositoryTasks;
import com.example.hcsappmvvm.model.User;

public class ChangeDataHelperViewModel extends ViewModel {

    public RepositoryTasks repositoryTasks = null;

    public void onSaveButtonClick(View view){
        repositoryTasks.ChangeData();
    }
}
