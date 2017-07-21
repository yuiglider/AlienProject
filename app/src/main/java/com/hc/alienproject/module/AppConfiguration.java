package com.hc.alienproject.module;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/21.
 */

public class AppConfiguration {

    private Set<Activity> activitySet;
    private static AppConfiguration appConfiguration;

    private AppConfiguration() {
    }

    public static AppConfiguration getInstance() {
        if (appConfiguration == null) {
            synchronized (AppConfiguration.class) {
                if (appConfiguration == null) {
                    appConfiguration = new AppConfiguration();
                }
            }
        }
        return appConfiguration;
    }


    public void exitAPP() {
        if (activitySet != null) {
            for (Activity activity : activitySet) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
}

    public void addActivity(Activity activity) {
        if (activitySet == null) {
            activitySet = new HashSet<>();
        }
        activitySet.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitySet.remove(activity);
    }

}
