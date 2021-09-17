package com.bw.di.component;

import android.app.Activity;
import android.content.Context;

import com.bw.di.module.ActivityModule;
import com.bw.di.scope.ActivityScope;

import dagger.Component;

/**
 * @ClassName ActivityComponent
 * @Author 孔晨亮
 * @Date 2021/9/16 18:56
 * User: msi
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();
    Context context();
}
