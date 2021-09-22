package com.zhang.home.data;

import com.bw.di.component.ActivityComponent;
import com.bw.di.component.FragmentComponent;
import com.bw.di.scope.PerComponentScope;
import com.zhang.home.DetailActivity;
import com.zhang.home.Dmvp.di.module.HomeModelModule;
import com.zhang.home.Dmvp.di.module.HomeViewModule;

import dagger.Component;

/**
 * @ClassName ActivityComponent
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 8:05
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@PerComponentScope
@Component(dependencies = {ActivityComponent.class},modules = {GoodsViewModule.class, GoodsModelModule.class})
public interface HomeActivityComponent {
    void injectDetail(DetailActivity activity);
}
