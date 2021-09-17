package com.bw.di.component;

import android.content.Context;

import com.bw.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ClassName AppComponent
 * @Author 孔晨亮
 * @Date 2021/9/16 18:41
 * User: msi
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();
}
