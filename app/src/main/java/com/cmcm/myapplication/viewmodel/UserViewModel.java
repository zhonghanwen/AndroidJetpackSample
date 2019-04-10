package com.cmcm.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cmcm.myapplication.MobileApp;
import com.cmcm.myapplication.db.entity.User;

import java.util.List;

/**
 * Created by zhonghanwen on 2019/04/09
 */
public class UserViewModel extends ViewModel {

    private MediatorLiveData<List<User>> mObservableUsers;


    public UserViewModel() {
        Log.d("UserViewModel", "onCreate");


        mObservableUsers = new MediatorLiveData<>();

        mObservableUsers.setValue(null);


        LiveData<List<User>> users = MobileApp.sMobileApp.getRepository().getAll();

        mObservableUsers.addSource(users, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mObservableUsers.setValue(users);
            }
        });
    }


    public LiveData<List<User>> getAllUser(){
        return mObservableUsers;
    }

}
