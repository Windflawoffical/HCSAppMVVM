package com.example.hcsappmvvm.DI;

import android.app.Application;

import com.example.hcsappmvvm.Room.AppealRoomRepository;
import com.example.hcsappmvvm.mock.MockBase;
import com.example.hcsappmvvm.network.AddressAnalysis;
import com.example.hcsappmvvm.repo.RepositoryTasks;

public class ServiceLocator {
    private static ServiceLocator instance = null;

    private ServiceLocator() {};

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }
    private AddressAnalysis mAnalysis;
    private RepositoryTasks mRepository;

    public void initBase(Application app) {
        if (mRepository == null) {
            mRepository = new AppealRoomRepository(app);
        }
    }

    public RepositoryTasks getRepository() {
        if (mRepository == null) {
            mRepository = new MockBase();
        }
        return mRepository;
    }

    public AddressAnalysis getAnalysis() {
        if (mAnalysis == null) {
            mAnalysis = new AddressAnalysis();
        }
        return mAnalysis;
    }
}
