package com.cmcm.myapplication.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * Created by zhonghanwen on 2019/04/08
 */
public class BasePresenter implements IPresenter {

    public static final String TAG = BasePresenter.class.getSimpleName();

    @Override
    public void onCreate(LifecycleOwner owner) {
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        Log.e(TAG, "onResume");
    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {
        Log.e(TAG, "onLifecycleChanged");

    }
}
