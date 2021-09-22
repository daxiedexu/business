package com.zhang.home.data;

import com.zhang.home.Dmvp.model.HomeModel;
import com.zhang.mvp_core.model.IModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * @ClassName GoodsModelModule
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 8:25
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Module
public class GoodsModelModule {
    @IntoMap
    @StringKey("goods")
    @Provides
    public IModel provideKinds(){
        return new GoodsModel();
    }
}
