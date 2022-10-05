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
        list.add(new Appeal("Жалоба №1", "Описание жалобы №1"));
        list.add(new Appeal("Жалоба №2", "Описание жалобы №2"));
        list.add(new Appeal("Жалоба №3", "Описание жалобы №3"));
        list.add(new Appeal("Жалоба №4", "Описание жалобы №4"));
        list.add(new Appeal("Жалоба №5", "Описание жалобы №5"));

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
