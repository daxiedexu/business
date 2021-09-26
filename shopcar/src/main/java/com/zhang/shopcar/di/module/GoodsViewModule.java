package com.zhang.shopcar.di.module;

import com.zhang.shopcar.contract.GoodsContract;
import com.zhang.shopcar.di.component.GoodsComponent;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName GoodsViewModule
 * @Author 孔晨亮
 * @Date 2021/9/23 15:48
 * User: msi
 */
@Module
public class GoodsViewModule {

    private GoodsContract goodsContract;

    public GoodsViewModule(GoodsContract _goodsContract) {
        goodsContract = _goodsContract;
    }

    @Provides
    public GoodsContract provideViewModel(){
        return goodsContract;
    }
}
