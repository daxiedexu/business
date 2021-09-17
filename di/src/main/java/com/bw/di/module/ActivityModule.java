package com.bw.di.module;

import android.app.Activity;

import com.bw.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName ActivityModule
 * @Author 孔晨亮
 * @Date 2021/9/16 18:45
 * User: msi
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity _activity) {
        activity=_activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity(){
        return activity;
    }
}
