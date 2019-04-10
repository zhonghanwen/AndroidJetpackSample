package com.cmcm.myapplication;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cmcm.myapplication.db.entity.User;
import com.cmcm.myapplication.presenter.GamePresenter;
import com.cmcm.myapplication.presenter.IPresenter;
import com.cmcm.myapplication.presenter.MainPresenter;
import com.cmcm.myapplication.viewmodel.NameViewModel;
import com.cmcm.myapplication.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity2 extends AppCompatActivity
    implements View.OnClickListener {

    private NameViewModel mNameViewModel;
    private UserViewModel mUserViewModel;

    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

        //get the ViewModel.
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        subscribeToModel();

    }

    private void subscribeToModel() {

        //Create the observer which updates the UI.
        Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //Update the UI, in this case, a TextView.
                mTvName.setText(s);
            }
        };

        mNameViewModel.getCurrentName().observe(this, nameObserver);


        mUserViewModel.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                Log.d("MainActivity2", "onChanged");
                if (users == null){
                    return;
                }
                for (User user : users) {
                    Log.e("MainActivity2", user.firstName);
                }
            }
        });
    }

    private void initListener() {
        mTvName.setOnClickListener(this);
    }

    private void initView() {
        mTvName = findViewById(R.id.tv_name);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onClick(View v) {
        String name = "Hello, ViewModel";
        mNameViewModel.getCurrentName().setValue(name);
    }
}
