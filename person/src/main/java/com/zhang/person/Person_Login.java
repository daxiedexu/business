package com.zhang.person;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhang.mvp_core.view.BaseActivity;

/**
 * @ClassName Person_Login
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/16 9:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Person_Config.LOGIN)
public class Person_Login extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.login;
    }
}
