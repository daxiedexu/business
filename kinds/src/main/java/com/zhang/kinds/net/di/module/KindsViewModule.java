package com.zhang.kinds.net.di.module;

import com.zhang.kinds.contrant.KindsContrant;
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
public class KindsViewModule {

    private KindsContrant kindsContrant;

    public KindsViewModule(KindsContrant _kindsContrant) {
        kindsContrant = _kindsContrant;
    }

    @Provides
    public KindsContrant provideViewModel(){
        return kindsContrant;
    }
}
