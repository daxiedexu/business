package com.zhang.common.utils.back;
import android.util.Log;

import com.zhang.common.BuildConfig;

/**
 * @ClassName LogUtils
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/13 19:06
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class LogUtils {
    private static final String TAG = "LogUtils";
    //日志判断常量
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;

    //根据DEBUG判断是否输出日志
    public static void writeLog(String desc,int tag,String message){
        if (BuildConfig.DEBUG){
            switch (tag){
                case VERBOSE:
                    Log.v(desc,message);
                    break;
                case DEBUG:
                    Log.d(desc,message);
                    break;
                case INFO:
                    Log.i(desc,message);
                    break;
                case WARN:
                    Log.w(desc,message);
                    break;
                case ERROR:
                    Log.e(desc,message);
                    break;
                default:
                    new TestException("请输入正确的日志等级!");
                    break;
            }
        }
    }
}
