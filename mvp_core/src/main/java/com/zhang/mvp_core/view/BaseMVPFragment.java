package com.zhang.mvp_core.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bw.di.BaseApplication;
import com.bw.di.component.DaggerFragmentComponent;
import com.bw.di.component.FragmentComponent;
import com.bw.di.module.FragmentModule;

/**
 * @ClassName BaseMVPFragment
 * @Author 孔晨亮
 * @Date 2021/9/16 19:18
 * User: msi
 */
public abstract class BaseMVPFragment extends BaseFragment{
    protected FragmentComponent fragmentComponent;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        fragmentComponent = DaggerFragmentComponent.builder().appComponent(((BaseApplication) getContext().getApplicationContext()).appComponent)
                .fragmentModule(new FragmentModule(this))
                .build();
        injectComponent();
        super.onActivityCreated(savedInstanceState);

    }

    protected abstract void injectComponent();
}
