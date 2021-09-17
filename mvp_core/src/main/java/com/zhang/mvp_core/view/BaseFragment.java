package com.zhang.mvp_core.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zhang.mvp_core.presenter.IPresenter;

import javax.inject.Inject;

/**
 * @ClassName BaseFregment
 * @Author 孔晨亮
 * @Date 2021/9/3 10:01
 * User: msi
 */
public abstract class BaseFragment extends Fragment {
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return view=inflater.inflate(bindLayout(),container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }
    protected abstract int bindLayout();

    protected abstract void initData();

    protected abstract void initView();

}
