package com.hc.alienproject.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/19.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        binder = ButterKnife.bind(this);
        initViews(savedInstanceState);
        initToolBar();
    }

    public abstract void initToolBar();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }
}
