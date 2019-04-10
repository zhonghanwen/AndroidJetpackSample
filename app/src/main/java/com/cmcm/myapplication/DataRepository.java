package com.cmcm.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.cmcm.myapplication.db.AppDatabase;
import com.cmcm.myapplication.db.entity.User;

import java.util.List;

/**
 * Created by zhonghanwen on 2019/04/09
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private final MediatorLiveData<List<User>> mObservableUsers;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableUsers = new MediatorLiveData<>();
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }




    public LiveData<List<User>> getAll() {
        return mDatabase.userDao().getAll();
    }


}
