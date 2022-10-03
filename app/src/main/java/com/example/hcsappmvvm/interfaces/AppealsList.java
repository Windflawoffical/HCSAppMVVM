package com.example.hcsappmvvm.interfaces;

import androidx.lifecycle.LiveData;

import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

public interface AppealsList {
    <T extends Appeal>LiveData<List<T>> getAppealsList();
}
