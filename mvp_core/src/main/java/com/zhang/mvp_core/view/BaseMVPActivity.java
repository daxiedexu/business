package com.zhang.mvp_core.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @ClassName BaseMVPActivity
 * @Author 孔晨亮
 * @Date 2021/9/16 19:07
 * User: msi
 */
public abstract class BaseMVPActivity extends BaseActivity {

    protected ActivityComponent activityComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activityComponent = DaggerActivityComponent.builder().appComponent(((BaseApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
        injectCompoent();
        super.onCreate(savedInstanceState);

    }

    protected abstract void injectCompoent();

}
