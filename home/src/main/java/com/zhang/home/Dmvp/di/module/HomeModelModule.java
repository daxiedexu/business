package com.zhang.home.Dmvp.di.module;

import com.zhang.home.Dmvp.model.HomeModel;
import com.zhang.mvp_core.model.IModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * @ClassName KindsModelModule
 * @Author 张海旭
 * @Date 2021/9/17 19:10
 * User: msi
 */
@Module
public class HomeModelModule {
    @IntoMap
    @StringKey("home")
    @Provides
    public IModel provideKinds(){
        return new HomeModel();
    }
}
