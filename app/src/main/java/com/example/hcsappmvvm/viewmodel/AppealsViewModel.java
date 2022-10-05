package com.example.hcsappmvvm.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.Room.AppealRoomRepository;
import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.repo.RepositoryContoller;

import java.util.List;

public class AppealsViewModel extends AndroidViewModel {
    private AppealRoomRepository repository;
    private LiveData<List<AppealRoom>> allAppeals;

    public AppealsViewModel(@NonNull Application application) {
        super(application);
        repository = new AppealRoomRepository(application);
        allAppeals = repository.getAllAppeals();
    }

    public void insert(AppealRoom appealRoom){
        repository.insert(appealRoom);
    }
    public void delete(AppealRoom appealRoom){
        repository.delete(appealRoom);
    }
    public LiveData<List<AppealRoom>> getAllAppeals(){
        return allAppeals;
    }
}
