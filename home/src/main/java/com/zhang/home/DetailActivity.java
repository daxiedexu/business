package com.zhang.home;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.common.utils.Config;
import com.zhang.home.data.DaggerHomeActivityComponent;
import com.zhang.home.data.GoodsPresenter;
import com.zhang.home.data.GoodsViewModule;
import com.zhang.home.data.View;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.Goods;
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
public class DetailActivity extends BaseMVPActivity implements View, OnItemClickListener {
    DetailAdapter detailAdapter;
    @Inject
    GoodsPresenter goodsPresenter;
    @Autowired(name=Config.DETAIL_KEY)
    String key;
    private RecyclerView detailRv;
    private TextView theme;
    @Override
    protected void initData() {
        detailRv.setLayoutManager(new GridLayoutManager(this,2));
        ARouter.getInstance().inject(this);
        if (key==null){
            theme.setText("推荐页面");
            GetGoodsListByKeywordReq getGoodsListByKeywordReq=new GetGoodsListByKeywordReq("1",1);
            goodsPresenter.getGoodsList(getGoodsListByKeywordReq);
        }else {
            GetGoodsListByKeywordReq getGoodsListByKeywordReq=new GetGoodsListByKeywordReq(key,1);
            goodsPresenter.getGoodsList(getGoodsListByKeywordReq);
        }
    }

    @Override
    protected void initView() {
        theme = (TextView) findViewById(R.id.theme);
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
            detailAdapter.setOnItemClickListener(this::onItemClick);
            detailRv.setAdapter(detailAdapter);
        }

    }

    @Override
    public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull android.view.View view, int position) {
        Goods item=(Goods) adapter.getItem(position);
        ARouter.getInstance().build(Config.MODULE_CAR).withParcelable("car",item).greenChannel().navigation();
    }

    public class DetailAdapter extends BaseQuickAdapter<Goods, BaseViewHolder>{
        public DetailAdapter(@Nullable List<Goods> data) {
            super(R.layout.detail_item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, Goods goods) {
            baseViewHolder.setText(R.id.detail_item_tv,goods.getGoodsDesc());
            baseViewHolder.setText(R.id.detail_item_price,"￥"+goods.getGoodsDefaultPrice().toString());
            baseViewHolder.setText(R.id.detail_item_sales,"销量"+goods.getGoodsSalesCount());
            baseViewHolder.setText(R.id.detail_item_stock,"库存"+goods.getGoodsStockCount()+"");
            Glide.with(getContext()).load(goods.getGoodsDefaultIcon()).into((ImageView) baseViewHolder.findView(R.id.detail_item_img));
        }
    }
}
