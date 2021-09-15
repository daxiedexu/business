package com.zhang.person;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhang.mvp_core.view.BaseActivity;

/**
 * @ClassName OrderStatus
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/15 8:44
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */


@Route(path=Person_Config.ORDER)
public class OrderStatus extends BaseActivity {

    @Override
    protected void initInject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.order;
    }
}
