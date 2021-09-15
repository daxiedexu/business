package com.zhang.home.mvp;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

/**
 * @ClassName IFragment
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/11 18:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface IFragment {
    @LayoutRes
    int bindLayout();
    void initView();
    void initData();
    public <T extends View> T findViewById(@IdRes int id);
}
