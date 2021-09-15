package com.zhang.home.lazy;

import com.zhang.home.R;

/**
 * @ClassName MyFragment
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/15 9:13
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class MyFragment extends BaseLazyLoadFragment{
    @Override
    protected void loadData() {
        //用来加载数据
    }

    @Override
    protected void initView() {
        //findViewById
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }
}
