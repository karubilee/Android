package com.example.karubi.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karubi on 2017/9/14.
 */

public class ActivityController {
    public static List<Activity>  activities = new ArrayList<>();

//    父类记得加入
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
//    父类记得移除
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
//    想杀进程的地方用
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
//        杀掉当前进程的代码,以保证完全退出,杀掉进程的代码如下
        android.os.Process.killProcess(android.os.Process.myPid());
        activities.clear();
    }
}
