package com.zhang.kinds.adapter;

import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.kinds.R;
import com.zhang.kinds.net.entitiy.Category;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName ComputerAdapter
 * @Author 孔晨亮
 * @Date 2021/9/21 19:59
 * User: msi
 */
public class ComputerAdapter extends BaseQuickAdapter<Category.DataBean, BaseViewHolder> {

    public ComputerAdapter(int layoutResId, @Nullable List<Category.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Category.DataBean item) {
        helper.setText(R.id.goods_tv, item.getCategoryName());
        Glide.with(getContext()).load(item.getCategoryIcon()).into((ImageView) helper.getView(R.id.goods_img));

    }

}
