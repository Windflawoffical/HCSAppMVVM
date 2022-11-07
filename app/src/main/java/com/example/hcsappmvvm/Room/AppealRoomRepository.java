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
    public <T extends Appeal> void insert(T appeal) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.insertAppeal(AppealRoom.convertToDB(appeal));
        });
    }
    public <T extends Appeal> void delete(T appeal) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.deleteAppeal(AppealRoom.convertToDB(appeal));
        });
    }
    public <T extends Appeal> void update(T appeal){
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.updateAppeal(AppealRoom.convertToDB(appeal));
        });
    }
    public LiveData<List<AppealRoom>> getAllAppeals() {
        return allAppeals;
    }

    public AppealRoom getAppealById(int id){
        return appealDAO.getAppealById(id);
    }

}

