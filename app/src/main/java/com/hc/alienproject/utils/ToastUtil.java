package com.hc.alienproject.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.hc.alienproject.App;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ToastUtil {

    public static void handle(String text){
        Toast.makeText(App.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    public static void handleView(View view,String text,String action,View.OnClickListener listener){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).setAction(action,listener).show();
    }
}
