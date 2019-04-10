package com.cmcm.myapplication.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * Created by zhonghanwen on 2019/04/08
 */
public class MainPresenter extends BasePresenter {

    public static final String TAG = MainPresenter.class.getSimpleName();

    @Override
    public void onCreate(LifecycleOwner owner) {
        super.onCreate(owner);
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        super.onDestroy(owner);
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        super.onStart(owner);
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        super.onResume(owner);
        Log.e(TAG, "onResume");
    }
}
