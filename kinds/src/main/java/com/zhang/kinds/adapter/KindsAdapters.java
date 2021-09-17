package com.zhang.kinds.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.kinds.R;
import com.zhang.kinds.net.entitiy.KindsEntitiy;

import java.util.List;

/**
 * @ClassName KindsAdapters
 * @Author 孔晨亮
 * @Date 2021/9/15 20:28
 * User: msi
 */
public class KindsAdapters extends BaseQuickAdapter<KindsEntitiy.DataBean, BaseViewHolder> {
    public KindsAdapters(List<KindsEntitiy.DataBean> data) {
        super(R.layout.item_rv_kinds, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KindsEntitiy.DataBean item) {
        helper.setText(R.id.kinds_tv_name,item.getCategory_name());
    }
}
