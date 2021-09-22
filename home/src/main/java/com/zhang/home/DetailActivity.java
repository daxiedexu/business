package com.zhang.home;

import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.common.utils.Config;
import com.zhang.home.data.DaggerHomeActivityComponent;
import com.zhang.home.data.GoodsPresenter;
import com.zhang.home.data.GoodsViewModule;
import com.zhang.home.data.View;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.mvp_core.view.BaseMVPActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    DetailAdapter detailAdapter;
    @Inject
    GoodsPresenter goodsPresenter;

    @Autowired(name=Config.DETAIL_KEY)
    String key;
    private RecyclerView detailRv;
    @Override
    protected void initData() {
        detailRv.setLayoutManager(new GridLayoutManager(this,2));

        ARouter.getInstance().inject(this);
        Toast.makeText(this, key, Toast.LENGTH_SHORT).show( );
        GetGoodsListByKeywordReq getGoodsListByKeywordReq=new GetGoodsListByKeywordReq(key,1);
        goodsPresenter.getGoodsList(getGoodsListByKeywordReq);
    }

    @Override
    protected void initView() {
        detailRv = (RecyclerView) findViewById(R.id.detail_rv);

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
    public void onGetGoodsListResult(BaseResp<ArrayList<Goods>> result) {
        ArrayList<Goods> data=result.getData( );

        if(detailAdapter==null){
            detailAdapter=new DetailAdapter(data);
            detailRv.setAdapter(detailAdapter);
        }

    }

    public class DetailAdapter extends BaseQuickAdapter<Goods, BaseViewHolder>{
        public DetailAdapter(@Nullable List<Goods> data) {
            super(R.layout.item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, Goods goods) {
            //baseViewHolder.setText(R.id.detail_item_tv,)
        }
    }
}
