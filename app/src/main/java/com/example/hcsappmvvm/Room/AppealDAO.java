package com.example.hcsappmvvm.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hcsappmvvm.model.Appeal;

import java.util.List;

@Dao
public interface AppealDAO {

    @Insert
    void insertAppeal(AppealRoom appealRoom);

    @Delete
    void deleteAppeal(AppealRoom appealRoom);

    @Query("SELECT * FROM appeal_table")
    LiveData<List<AppealRoom>> getAllAppeals();

}
