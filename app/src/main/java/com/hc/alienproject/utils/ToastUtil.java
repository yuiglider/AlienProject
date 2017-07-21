package com.hc.alienproject.utils;

import android.widget.Toast;

import com.hc.alienproject.App;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ToastUtil {

    public static void handle(String text){
        Toast.makeText(App.getContext(),text,Toast.LENGTH_SHORT).show();
    }
}
