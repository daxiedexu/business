package com.zhang.home;

import android.util.Log;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.di.component.DaggerActivityComponent;
import com.zhang.common.utils.Config;
import com.zhang.home.data.DaggerHomeActivityComponent;
import com.zhang.home.data.GoodsPresenter;
import com.zhang.home.data.GoodsViewModule;
import com.zhang.home.data.View;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseMVPActivity;
import java.util.ArrayList;
import javax.inject.Inject;

import retrofit2.http.Body;

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
        GetGoodsListByKeywordReq getGoodsListByKeywordReq=new GetGoodsListByKeywordReq(key,10);
        goodsPresenter.getGoodsList(getGoodsListByKeywordReq);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.detail;
    }

    @Override
    protected void injectCompoent() {
        DaggerHomeActivityComponent.builder().activityComponent(activityComponent)
                .goodsViewModule(new GoodsViewModule(this))
                .build().injectDetail(this);
    }

    @Override
    public void onGetGoodsListResult(ArrayList<Goods> result) {

    }

}
