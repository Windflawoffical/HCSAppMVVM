package com.example.hcsappmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.Room.AppealRoomRepository;

import java.util.List;

public class EditAppealViewModel extends AndroidViewModel {

    private AppealRoomRepository repository;
    private LiveData<List<AppealRoom>> allAppeals;

    public EditAppealViewModel(@NonNull Application application) {
        super(application);
        repository = new AppealRoomRepository(application);
        allAppeals = repository.getAllAppeals();
    }
    public void update(AppealRoom appealRoom){
        repository.update(appealRoom);
    }
}
