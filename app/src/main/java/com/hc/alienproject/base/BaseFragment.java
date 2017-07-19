package com.hc.alienproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/19.
 */

public abstract class BaseFragment extends RxFragment {

    private Unbinder binder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(getLayoutID(), container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = ButterKnife.bind(this, view);
        CreatedView(savedInstanceState);
    }

    public abstract void CreatedView(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    public abstract LayoutInflater getLayoutID();

    public  void initData(){

    };

}
