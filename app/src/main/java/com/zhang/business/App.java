package com.zhang.business;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import com.zhang.common.utils.back.ProgressManger;

/**
 * @ClassName App
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/11 8:11
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class App extends Application {
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        super.onCreate();
        //通过包名去判断当前执行进程，防止多次初始化
        String result = ProgressManger.getProcessName(this, Process.myPid());
        if (!TextUtils.isEmpty(result)&&result.equalsIgnoreCase(getPackageName())){
            Log.i(TAG, String.format("当前初始化进程是：%s",getPackageName()));
        }
    }
}
