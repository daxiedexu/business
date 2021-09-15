package com.zhang.home.lazy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName BaseFragment
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/15 9:06
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public abstract class BaseFragment extends Fragment {
    private View baseView;
    private boolean isLazyLoad;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(bindLayout(),container,false);
        return baseView;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!isLazyLoad){
            loadData();
        }
    }

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract int bindLayout();

    public void setLazyLoad(boolean lazyLoad) {
        isLazyLoad = lazyLoad;
    }
}
