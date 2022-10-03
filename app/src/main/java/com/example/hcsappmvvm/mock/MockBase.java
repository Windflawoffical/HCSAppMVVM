package com.example.hcsappmvvm.mock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.interfaces.AppealsList;
import com.example.hcsappmvvm.model.Appeal;

import java.util.ArrayList;
import java.util.List;

public class MockBase implements AddAppeal, AppealsList {
    private MutableLiveData<List<Appeal>> data;
    private List<Appeal> list;

    public MockBase() {
        list = new ArrayList<>();
        data = new MutableLiveData<>(list);
    }

    @Override
    public <T extends Appeal> void addAppeal(Appeal appeal) {
        list.add(appeal);
        data.setValue(list);
    }


    @Override
    public <T extends Appeal> LiveData<List<T>> getappealsList() {
        return (MutableLiveData) data;
    }
}
