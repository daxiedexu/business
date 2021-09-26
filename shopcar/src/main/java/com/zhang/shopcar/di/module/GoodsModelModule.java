package com.zhang.shopcar.di.module;

import com.zhang.mvp_core.model.IModel;
import com.zhang.shopcar.model.GoodsCarModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/**
 * @ClassName GoodsModelModule
 * @Author 孔晨亮
 * @Date 2021/9/23 15:48
 * User: msi
 */
@Module
public class GoodsModelModule {

    @IntoMap
    @StringKey("goods")
    @Provides
    public IModel provideGoods(){
        return new GoodsCarModel();
    }

}
