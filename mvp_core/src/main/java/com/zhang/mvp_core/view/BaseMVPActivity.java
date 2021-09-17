package com.zhang.mvp_core.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.bw.di.BaseApplication;
import com.bw.di.component.ActivityComponent;
import com.bw.di.component.DaggerActivityComponent;
import com.bw.di.module.ActivityModule;
import com.zhang.mvp_core.presenter.IPresenter;

/**
 * @ClassName BaseMVPActivity
 * @Author 孔晨亮
 * @Date 2021/9/16 19:07
 * User: msi
 */
public abstract class BaseMVPActivity<P extends IPresenter> extends BaseActivity {

    protected ActivityComponent activityComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder().appComponent(((BaseApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
        injectCompoent();
    }

    protected abstract void injectCompoent();

}
