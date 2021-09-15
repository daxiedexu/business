package com.zhang.kinds.net.di;

import com.zhang.kinds.repository.KindsRepositoryImpl;

import dagger.Component;

/**
 * @ClassName KindsComponent
 * @Author 孔晨亮
 * @Date 2021/9/15 8:03
 * User: msi
 */
@Component(modules = KindsModule.class)
public interface KindsComponent {
    void inject(KindsRepositoryImpl kindsRepository);
}
