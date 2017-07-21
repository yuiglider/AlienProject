package com.hc.alienproject.module.common;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import com.hc.alienproject.module.AppConfiguration;
import com.hc.alienproject.utils.ToastUtil;
import com.yui.alienproject.R;
import com.hc.alienproject.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private long exitTime = 0L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void loadData() {
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApp();
        }
        return true;
    }

    private void exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtil.handle("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            AppConfiguration.getInstance().exitAPP();
        }
    }

}
