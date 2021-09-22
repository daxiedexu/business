package com.zhang.home;

import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhang.common.utils.Config;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseFragment;

/**
 * @ClassName Car_Fragment
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 11:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

public class CarGood_Fragment extends BaseFragment {

    @Override
    protected int bindLayout() {
        return R.layout.cargood;
    }

    @Override
    protected void initData() {
        Goods cargood=getArguments( ).getParcelable("cargood");
        Toast.makeText(getContext(), cargood.getCategoryId()+"", Toast.LENGTH_SHORT).show( );
    }

    @Override
    protected void initView() {

    }


    @Override
    public void onStart() {
        super.onStart( );



    }
}
