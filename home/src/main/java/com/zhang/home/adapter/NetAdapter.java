package com.zhang.home.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.home.R;
import com.zhang.home.entity.NetEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName NetAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/12 20:22
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NetAdapter extends BaseQuickAdapter<NetEntity, BaseViewHolder> {
    public NetAdapter(@Nullable List<NetEntity> data) {
        super(R.layout.net_item, data);

    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NetEntity netEntity) {


        baseViewHolder.setText(R.id.net_title,netEntity.getTitle());
        Glide.with(getContext())
                .load(netEntity.getImage())
                .into((ImageView) baseViewHolder.findView(R.id.net_image));
    }
}
