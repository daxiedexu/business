package com.zhang.kinds.adapter;

import android.graphics.Color;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.kinds.R;
import com.zhang.kinds.net.entitiy.Category;

import java.util.List;

/**
 * @ClassName KindsAdapters
 * @Author 孔晨亮
 * @Date 2021/9/15 20:28
 * User: msi
 */
public class KindsAdapters extends BaseQuickAdapter<Category.DataBean, BaseViewHolder> {
    public KindsAdapters(List<Category.DataBean> data) {
        super(R.layout.item_rv_kinds, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Category.DataBean item) {
        helper.setText(R.id.kinds_tv_name,item.getCategoryName());
        if (item.isCheck()){
            helper.setTextColor(R.id.kinds_tv_name,Color.parseColor("#ff8800"));
            helper.setBackgroundColor(R.id.kinds_tv_name,Color.parseColor("#F6F6F6"));
        }else {
            helper.setBackgroundColor(R.id.kinds_tv_name,Color.parseColor("#FFFFFF"));
            helper.setTextColor(R.id.kinds_tv_name,Color.parseColor("#000000"));
        }


    }
}
