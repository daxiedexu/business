package com.zhang.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.net.ShopCar;
import com.zhang.person.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PayAdapters
 * @Author 孔晨亮
 * @Date 2021/10/7 19:08
 * User: msi
 */
public class PayAdapters extends BaseQuickAdapter<ShopCar, BaseViewHolder> {
    public PayAdapters(int layoutResId, @Nullable List<ShopCar> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ShopCar shopCar) {
        baseViewHolder.setText(R.id.pay_item_names,shopCar.getGoodsname());
        baseViewHolder.setText(R.id.pay_item_msgs,shopCar.getGoodsmsg());
        baseViewHolder.setText(R.id.pay_item_price,shopCar.getPrice()+"");
        baseViewHolder.setText(R.id.pay_item_prices,shopCar.getPrice()+"");
        Glide.with(getContext()).load(shopCar.getPic()).into((ImageView) baseViewHolder.findView(R.id.pay_item_imgs));

        addChildClickViewIds(R.id.pay_btn_pay);
        addChildClickViewIds(R.id.pay_btn_clar);



    }
}
