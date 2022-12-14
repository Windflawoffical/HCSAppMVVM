package com.example.hcsappmvvm.Room;

import android.app.Application;
import android.os.AsyncTask;
import android.webkit.WebViewClient;

import androidx.lifecycle.LiveData;
import com.example.hcsappmvvm.Room.AppealDatabase;

import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.network.VK.OAuth2;
import com.example.hcsappmvvm.repo.RepositoryTasks;
import com.example.hcsappmvvm.view.OAuth_VK;

import java.io.File;
import java.util.List;

public class AppealRoomRepository implements RepositoryTasks {
    private AppealDAO appealDAO;
    private LiveData<List<AppealRoom>> allAppeals;

    public AppealRoomRepository(Application application) {
        AppealDatabase database = AppealDatabase.getInstance(application);
        appealDAO = database.appealDAO();
        allAppeals = appealDAO.getAllAppeals();
    }
    public LiveData<List<AppealRoom>> getAllAppeals() {
        return allAppeals;
    }

    @Override
    public void insertAppeal(Appeal appeal) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.insertAppeal(AppealRoom.convertToDB(appeal));
        });
    }

    @Override
    public void deleteAppeal(Appeal appeal) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.deleteAppeal(AppealRoom.convertToDB(appeal));
        });
    }

    @Override
    public void updateAppeal(Appeal appeal) {
        AppealDatabase.databaseWriteExecutor.execute(()->{
            appealDAO.updateAppeal(AppealRoom.convertToDB(appeal));
        });
    }

    public AppealRoom getAppealById(int id){
        return appealDAO.getAppealById(id);
    }

    public static WebViewClient getClient(OAuth_VK auth_vk) {
        return OAuth2.getWebViewClient(auth_vk);
    }

}

