package com.example.hcsappmvvm.repo;

import android.app.Application;

import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.interfaces.AppealsList;
import com.example.hcsappmvvm.mock.MockBase;

public class RepositoryContoller {
    static AddAppeal appeal;
    static AppealsList appealsList;

    public static AddAppeal getAddAppeal(){
        if(appeal == null){
            appeal = new MockBase();
        }
        return appeal;
    }

    public static AppealsList getAppealsList(){
        if(appealsList == null){
            appealsList = new MockBase();
        }
        return appealsList;
    }
}
