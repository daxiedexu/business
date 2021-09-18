package com.zhang.kinds.net.di.module;

import com.zhang.kinds.model.KindsModel;
import com.zhang.mvp_core.model.IModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * @ClassName KindsModelModule
 * @Author 孔晨亮
 * @Date 2021/9/17 19:10
 * User: msi
 */
@Module
public class KindsModelModule {
    @IntoMap
    @StringKey("kinds")
    @Provides
    public IModel provideKinds(){
        return new KindsModel();
    }
}
