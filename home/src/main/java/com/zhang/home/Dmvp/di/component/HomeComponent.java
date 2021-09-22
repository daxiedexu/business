package com.zhang.home.Dmvp.di.component;

import android.app.Activity;

import com.bw.di.component.FragmentComponent;
import com.bw.di.scope.PerComponentScope;
import com.zhang.home.DetailActivity;
import com.zhang.home.Dmvp.di.module.HomeModelModule;
import com.zhang.home.Dmvp.di.module.HomeViewModule;
import com.zhang.home.HomeFragment;

import dagger.Component;

/**
 * @ClassName KindsComponent
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 11:13
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
@PerComponentScope
@Component(dependencies = {FragmentComponent.class},modules = {HomeViewModule.class, HomeModelModule.class})
public interface HomeComponent {
    void injectKinds(HomeFragment homeFragment);

}