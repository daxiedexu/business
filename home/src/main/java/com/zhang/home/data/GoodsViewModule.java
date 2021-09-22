package com.zhang.home.data;

import com.zhang.home.Dmvp.contract.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName GoodsViewModule
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 8:26
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

@Module
public class GoodsViewModule {
    private View view;

    public GoodsViewModule(View view) {
        this.view=view;
    }
    @Provides
    public View provideViewModel(){
        return view;
    }
}
