package com.example.hcsappmvvm.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.hcsappmvvm.Room.AppealDatabase;

import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

public class AppealRoomRepository {
    private AppealDAO appealDAO;
    private LiveData<List<AppealRoom>> allAppeals;

    public AppealRoomRepository(Application application) {
        AppealDatabase database = AppealDatabase.getInstance(application);
        appealDAO = database.appealDAO();
        allAppeals = appealDAO.getAllAppeals();
    }
    public void insert(AppealRoom appealRoom) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.insertAppeal(appealRoom);
        });
    }
    public void delete(AppealRoom appealRoom) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.deleteAppeal(appealRoom);
        });
    }
    public LiveData<List<AppealRoom>> getAllAppeals() {
        return allAppeals;
    }

}

