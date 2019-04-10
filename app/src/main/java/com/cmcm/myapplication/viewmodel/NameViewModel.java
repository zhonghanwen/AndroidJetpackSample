package com.cmcm.myapplication.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by zhonghanwen on 2019/04/09
 */
public class NameViewModel extends ViewModel {

    private MutableLiveData<String> currentName;


    public MutableLiveData<String> getCurrentName() {
        if (currentName == null){
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }
}
