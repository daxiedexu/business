package com.zhang.shopcar;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.net.ShopCar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import ren.qinc.numberbutton.NumberButton;

/**
 * @ClassName ShopAdapter
 * @Author 孔晨亮
 * @Date 2021/9/23 20:47
 * User: msi
 */
public class ShopAdapter extends BaseQuickAdapter<ShopCar, BaseViewHolder> {
    public ShopAdapter(int layoutResId, List<ShopCar> list) {
        super(layoutResId,list);

    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ShopCar shopCar) {
        baseViewHolder.setText(R.id.shop_name,shopCar.getGoodsname());
        baseViewHolder.setText(R.id.shop_msg,shopCar.getGoodsmsg());
        baseViewHolder.setText(R.id.shop_price,shopCar.getPrice()+"");
        NumberButton numberButton = baseViewHolder.getView(R.id.shop_number);
        numberButton.setCurrentNumber(shopCar.getNum());
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number = numberButton.getNumber();
                Log.d("11111", "onClick: "+number);
                shopCar.setNum(number);
            }
        });
        Glide.with(getContext()).load(shopCar.getPic()).into((ImageView) baseViewHolder.getView(R.id.shop_im));
        CheckBox view = baseViewHolder.getView(R.id.shop_check);
        view.setChecked(shopCar.getIsCheck());
        bindViewClickListener(baseViewHolder,baseViewHolder.getItemViewType());
        addChildClickViewIds(R.id.shop_check);
        addChildClickViewIds(R.id.shop_number);


    }
}
