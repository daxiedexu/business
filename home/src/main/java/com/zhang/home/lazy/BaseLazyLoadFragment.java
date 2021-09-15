package com.zhang.home.lazy;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName BaseLazyLoadFragment
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/15 9:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public abstract class BaseLazyLoadFragment extends BaseFragment{
    //是否已经初始化结束
    private boolean isPrepare;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLazyLoad(true);
        isPrepare = true;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建时要判断是否已经显示给用户，加载数据
        onVisibleToUser();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        onVisibleToUser();
    }

    /**
     * 判断是否需要加载数据
     */
    private void onVisibleToUser() {
        if (isPrepare && getUserVisibleHint()){
            loadData();
        }
    }
}
