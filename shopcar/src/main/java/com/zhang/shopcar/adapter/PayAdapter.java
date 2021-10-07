package com.zhang.shopcar.adapter;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.net.ShopCar;
import com.zhang.shopcar.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import ren.qinc.numberbutton.NumberButton;

/**
 * @ClassName ShopAdapter
 * @Author 孔晨亮
 * @Date 2021/9/23 20:47
 * User: msi
 */
public class PayAdapter extends BaseQuickAdapter<ShopCar, BaseViewHolder> {
    public PayAdapter(int layoutResId, @Nullable List<ShopCar> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ShopCar shopCar) {
        Glide.with(getContext()).load(shopCar.getPic()).into((ImageView) baseViewHolder.findView(R.id.pay_item_im));
        baseViewHolder.setText(R.id.pay_item_name,shopCar.getGoodsname());
        baseViewHolder.setText(R.id.pay_item_msg,shopCar.getGoodsmsg());
        baseViewHolder.setText(R.id.pay_item_price,shopCar.getPrice()+"");
    }
}
