package com.bw.di.module;

import android.content.Context;

import com.bw.di.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName AppModule
 * @Author 孔晨亮
 * @Date 2021/9/16 18:38
 * User: msi
 */
@Module
public class AppModule {

    private BaseApplication baseApplication;
    public AppModule(BaseApplication application) {
        baseApplication=application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return baseApplication;
    }

}
