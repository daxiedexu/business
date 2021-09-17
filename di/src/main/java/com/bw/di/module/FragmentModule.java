package com.bw.di.module;

import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName FragmentModule
 * @Author 孔晨亮
 * @Date 2021/9/16 19:40
 * User: msi
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment _fragment) {
        fragment = _fragment;
    }

    @Provides
    public Fragment provideFragment(){
        return fragment;
    }
}
