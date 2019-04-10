package com.cmcm.myapplication;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cmcm.myapplication.presenter.GamePresenter;
import com.cmcm.myapplication.presenter.IPresenter;
import com.cmcm.myapplication.presenter.MainPresenter;
import com.cmcm.myapplication.presenter.MyPresenter;

public class MainActivity extends Activity implements LifecycleOwner {

//    private MyPresenter presenter;

    private IPresenter mPresenter;
    private IPresenter mGamePresenter;

    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        presenter = new MyPresenter();
//        presenter.onCreate();

        mPresenter = new MainPresenter();
        mGamePresenter = new GamePresenter();

        mLifecycleRegistry.addObserver(mPresenter);
        mLifecycleRegistry.addObserver(mGamePresenter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        presenter.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        presenter.onDestroy();

        if (mPresenter != null){
            mLifecycleRegistry.removeObserver(mPresenter);
        }
        if (mGamePresenter != null){
            mLifecycleRegistry.removeObserver(mGamePresenter);
        }
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
