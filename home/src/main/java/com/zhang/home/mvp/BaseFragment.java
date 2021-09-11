package com.zhang.home.mvp;

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
 * @Date 2021/9/11 18:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public abstract class BaseFragment extends Fragment implements IFragment {
    private View baseView;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        if (baseView==null){
            baseView = inflater.inflate(bandLayout(),container,false);
        }
        return baseView;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return baseView.findViewById(id);
    }
}
