package com.zhang.home.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.home.R;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.Goods;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName HomeAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/21 18:30
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {
    public HomeAdapter(@Nullable List<Goods> data) {
        super(R.layout.home_item, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Goods goods) {
        Glide.with(getContext()).load(goods.getGoodsDefaultIcon()).into((ImageView) baseViewHolder.findView(R.id.home_image));
        baseViewHolder.setText(R.id.home_desc,goods.getGoodsDesc());
        baseViewHolder.setText(R.id.home_price,goods.getGoodsDefaultPrice().toString());
        baseViewHolder.setText(R.id.home_stockCount,String.valueOf(goods.getGoodsStockCount()));

    }
}
