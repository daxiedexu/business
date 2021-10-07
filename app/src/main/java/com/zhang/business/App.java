package com.zhang.business;

import android.os.Process;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.sdk.android.cloudcode.CloudCodeInitializer;
import com.alibaba.sdk.android.cloudcode.CloudCodeLog;
import com.alibaba.sdk.android.logger.LogLevel;
import com.bw.di.BaseApplication;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.rtmp.TXLiveBase;
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
public class App extends BaseApplication {
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        super.onCreate();
        //通过包名去判断当前执行进程，防止多次初始化
        String result = ProgressManger.getProcessName(this, Process.myPid());
        if (!TextUtils.isEmpty(result)&&result.equalsIgnoreCase(getPackageName())){
            CloudCodeInitializer.setOAID(null);
            // 调用云码sdk初始化
            CloudCodeInitializer.init(this);
            CloudCodeLog.setLevel(LogLevel.DEBUG);
            CrashReport.initCrashReport(getApplicationContext(), "06a3451d22", BuildConfig.DEBUG);
            //SophixManager.getInstance().queryAndLoadNewPatch();//阿里热修复

        }

        // 必须在初始化ARouter之前配置
        if (BuildConfig.DEBUG){
            // 日志开启
            ARouter.openLog();
            // 调试模式开启，如果在install run模式下运行，则必须开启调试模式
            ARouter.openDebug();
        }
        ARouter.init(this);
        String licenceURL = "https://license.vod2.myqcloud.com/license/v2/1305875465_1/v_cube.license"; // 获取到的 licence url
        String licenceKey = "9e68b2164b89299715e6ef4279c9ae5b"; // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey);
    }
}
