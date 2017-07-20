package com.hc.alienproject.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.example.yui.alienproject.R;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class SplashActivity extends RxActivity {

    private Unbinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        binder = ButterKnife.bind(this);
        hideStatusBar(getWindow(), true);
        setUpSplash();
    }

    private void setUpSplash() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() {
            @Override
            public void accept(@NonNull Object o) throws Exception {
                finishTask();
            }
        });
    }

    private void finishTask() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binder.unbind();
    }

    private void hideStatusBar(Window window, boolean enable) {
        WindowManager.LayoutParams p = window.getAttributes();
        //|=：或等于，取其一
        if (enable) {
            p.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        } else {
            //&=：与等于，取其二同时满足，     ~ ： 取反
            p.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        window.setAttributes(p);
//        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
