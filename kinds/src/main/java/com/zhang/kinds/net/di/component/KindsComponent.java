package com.zhang.kinds.net.di.component;

import com.bw.di.component.FragmentComponent;
import com.bw.di.scope.PerComponentScope;
import com.zhang.kinds.net.di.module.KindsModelModule;
import com.zhang.kinds.net.di.module.KindsViewModule;
import com.zhang.kinds.view.KindsFragment;

import dagger.Component;

/**
 * @ClassName KindsComponent
 * @Author 孔晨亮
 * @Date 2021/9/15 8:03
 * User: msi
 */
@PerComponentScope
@Component(dependencies = {FragmentComponent.class},modules = {KindsViewModule.class, KindsModelModule.class})
public interface KindsComponent {
    void injectKinds(KindsFragment kindsFragment);
}
