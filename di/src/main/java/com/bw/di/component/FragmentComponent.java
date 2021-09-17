package com.bw.di.component;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.bw.di.module.FragmentModule;
import com.bw.di.scope.ActivityScope;

import dagger.Component;

/**
 * @ClassName FragmentComponent
 * @Author 孔晨亮
 * @Date 2021/9/16 19:40
 * User: msi
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {FragmentModule.class})
public interface FragmentComponent {
    Fragment fragment();
    Context context();
}
