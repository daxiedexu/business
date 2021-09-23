package com.zhang.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhang.common.utils.Config;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //置空window背景图
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    /**
     * 等待视图能够获取焦点跳转登录页面
     * 1.在视图获取到焦点的时候去跳转
     * 2.在视图失去焦点的时候去杀死Activity
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            ARouter.getInstance().build(Config.MODULE_SPLASH).navigation();
        }else {
            finish();
        }
    }
}