package com.zhang.shopcar.di.component;


import com.bw.di.component.ActivityComponent;
import com.bw.di.component.FragmentComponent;
import com.bw.di.scope.PerComponentScope;
import com.zhang.shopcar.PayActivity;
import com.zhang.shopcar.ShopCarFragment;
import com.zhang.shopcar.di.module.GoodsModelModule;
import com.zhang.shopcar.di.module.GoodsViewModule;

import dagger.Component;

/**
 * @ClassName GoodsComponent
 * @Author 孔晨亮
 * @Date 2021/9/23 15:48
 * User: msi
 */
@PerComponentScope
@Component(dependencies = {ActivityComponent.class},modules = {GoodsViewModule.class, GoodsModelModule.class})
public interface PayComponent {
    void injectGoods(PayActivity payActivity);
}
