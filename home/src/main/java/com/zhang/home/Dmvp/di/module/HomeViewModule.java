package com.zhang.home.Dmvp.di.module;

import com.zhang.home.Dmvp.contract.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName KindsModule
 * @Author 张海旭
 * @Date 2021/9/14 20:32
 * User: msi
 */
@Module
public class HomeViewModule {

    private HomeContract homeContract;

    public HomeViewModule(HomeContract _homeContract) {
        homeContract = _homeContract;
    }

    @Provides
    public HomeContract provideViewModel(){
        return homeContract;
    }
}
