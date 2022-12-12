package com.example.hcsappmvvm.mock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.repo.RepositoryTasks;

import java.util.ArrayList;
import java.util.List;

public class MockBase implements RepositoryTasks {
    private MutableLiveData<List<Appeal>> data;
    private List<Appeal> list;

    public MockBase() {
        list = new ArrayList<>();
        data = new MutableLiveData<>(list);
        list.add(new Appeal("Жалоба №1", "Описание жалобы №1", "Image1", "Moscow", "Accepted"));
        list.add(new Appeal("Жалоба №2", "Описание жалобы №2", "Image2","Moscow", "Accepted"));
        list.add(new Appeal("Жалоба №3", "Описание жалобы №3", "Image3","Moscow", "Accepted"));
        list.add(new Appeal("Жалоба №4", "Описание жалобы №4", "Image4","Moscow", "Accepted"));
        list.add(new Appeal("Жалоба №5", "Описание жалобы №5", "Image5","Moscow", "Accepted"));

    }

    @Override
    public void insertAppeal(Appeal appeal) {
        list.add(appeal);
        data.setValue(list);
    }

    @Override
    public void deleteAppeal(Appeal appeal) {
        list.remove(appeal);
        data.setValue(list);
    }

    @Override
    public void updateAppeal(Appeal appeal) {
        list.set(3,appeal);
        data.setValue(list);
    }

    @Override
    public <T extends Appeal> LiveData<List<Appeal>> getAllAppeals() {
        return data;
    }

    @Override
    public AppealRoom getAppealById(int id) {
        Appeal appeal = new Appeal();
        appeal = list.get(id);
        return AppealRoom.convertToDB(appeal);
    }
}
