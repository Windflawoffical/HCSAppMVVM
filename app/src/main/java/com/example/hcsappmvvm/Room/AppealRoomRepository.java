package com.example.hcsappmvvm.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

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
        new InsertAppealAsyncTask(appealDAO).execute(appealRoom);
    }
    public void delete(AppealRoom appealRoom) {
        new DeleteAppealAsyncTask(appealDAO).execute(appealRoom);
    }
    public LiveData<List<AppealRoom>> getAllAppeals() {
        return allAppeals;
    }
    private static class InsertAppealAsyncTask extends AsyncTask<AppealRoom, Void, Void> {
        private AppealDAO appealDAO;

        private InsertAppealAsyncTask(AppealDAO appealDAO) {
            this.appealDAO = appealDAO;
        }
        @Override
        protected Void doInBackground(AppealRoom... appealRooms) {
            appealDAO.insertAppeal(appealRooms[0]);
            return null;
        }
    }
    private static class DeleteAppealAsyncTask extends AsyncTask<AppealRoom, Void, Void> {
        private AppealDAO appealDAO;

        private DeleteAppealAsyncTask(AppealDAO appealDAO) {
            this.appealDAO = appealDAO;
        }
        @Override
        protected Void doInBackground(AppealRoom... appealsRooms) {
            appealDAO.deleteAppeal(appealsRooms[0]);
            return null;
        }
    }
}

