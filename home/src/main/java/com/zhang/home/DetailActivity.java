package com.zhang.home;

import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhang.common.utils.Config;
import com.zhang.home.data.GoodsPresenter;
import com.zhang.home.data.View;
import com.zhang.mvp_core.view.BaseActivity;
import com.zhang.mvp_core.view.BaseMVPActivity;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @ClassName DetailActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/18 11:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Config.MODULE_DETAIL)
public class DetailActivity extends BaseMVPActivity implements View {

    @Inject
    GoodsPresenter goodsPresenter;

    @Autowired(name=Config.DETAIL_KEY)
    String key;

    @Override
    protected void initData() {
        ARouter.getInstance().inject(this);
        Toast.makeText(this, key, Toast.LENGTH_SHORT).show( );

        goodsPresenter.getGoodsList(key,1);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.detail;
    }

    @Override
    public void onGetGoodsListResult(ArrayList<Goods> result) {

    }

    @Override
    protected void injectCompoent() {
//        DaggerKindsComponent.builder().fragmentComponent(fragmentComponent)
//                .kindsViewModule(new KindsViewModule(this))
//                .build().injectKinds(this);


    }
}
