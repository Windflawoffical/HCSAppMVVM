package com.example.hcsappmvvm.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hcsappmvvm.model.Appeal;

@Database(entities = {AppealRoom.class},version = 1)
public abstract class AppealDatabase extends RoomDatabase {

    private static AppealDatabase instance;

    public abstract AppealDAO appealDAO();

    public static synchronized AppealDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppealDatabase.class, "appeal_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
