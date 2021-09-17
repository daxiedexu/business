package com.zhang.kinds.net.di;

import com.zhang.kinds.model.KindsModel;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName KindsModule
 * @Author 孔晨亮
 * @Date 2021/9/14 20:32
 * User: msi
 */
@Module
public class KindsModule {

    @Provides
    public KindsModel getKindsModel(){
        return new KindsModel();
    }
}
