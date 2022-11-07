package com.example.hcsappmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.Room.AppealRoomRepository;
import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

public class AddAppealViewModel extends AndroidViewModel {

    private AppealRoomRepository repository;
    private LiveData<List<AppealRoom>> allAppeals;

    public AddAppealViewModel(@NonNull Application application) {
        super(application);
        repository = new AppealRoomRepository(application);
        allAppeals = repository.getAllAppeals();
    }
    public void insert(Appeal appeal){
        repository.insert(appeal);
    }

}
