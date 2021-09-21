package com.zhang.home.adapter;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.home.entity.DiscountEntity;
import com.zhang.home.width.MoreMoneyView;
import com.zhang.home.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 * @ClassName DiscountAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/17 16:22
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class DiscountAdapter extends BaseQuickAdapter<DiscountEntity, BaseViewHolder> {
    public DiscountAdapter(@Nullable List<DiscountEntity> data) {
        super(R.layout.discount_item, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, DiscountEntity discountEntity) {
        ImageView imageView = baseViewHolder.getView(R.id.discount_image);
        MoreMoneyView moreMoneyView = baseViewHolder.findView(R.id.discount_more);
        Glide.with(getContext()).load(discountEntity.getDiscountUrl()).into(imageView);
        moreMoneyView.bringToFront();
        baseViewHolder.setText(R.id.discount_price,discountEntity.getPrice());
        TextView textView = baseViewHolder.findView(R.id.discount_morePrice);
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        baseViewHolder.setText(R.id.discount_morePrice,discountEntity.getMorePrice());
    }
}
