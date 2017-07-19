package com.hc.alienproject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yui.alienproject.R;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplashActivity extends RxActivity {
    private Unbinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        binder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }
}
