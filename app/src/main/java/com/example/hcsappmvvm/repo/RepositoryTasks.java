package com.example.hcsappmvvm.repo;

import androidx.lifecycle.LiveData;

import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

public interface RepositoryTasks {
    void insertAppeal(Appeal appeal);
    void deleteAppeal(Appeal appeal);
    void updateAppeal(Appeal appeal);
    <T extends Appeal> LiveData<List<Appeal>> getAllAppeals();
    AppealRoom getAppealById(int id);



}
