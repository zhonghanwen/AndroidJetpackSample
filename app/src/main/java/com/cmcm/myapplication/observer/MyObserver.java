package com.cmcm.myapplication.observer;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * Created by zhonghanwen on 2019/04/08
 */
public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){

    }


}
