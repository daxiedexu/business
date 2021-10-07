package com.zhang.shopcar.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhang.net.AdressCar;
import com.zhang.net.ShopCar;
import com.zhang.shopcar.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName ShopAdapter
 * @Author 孔晨亮
 * @Date 2021/9/23 20:47
 * User: msi
 */
public class AdressAdapter extends BaseQuickAdapter<AdressCar, BaseViewHolder> {


    public AdressAdapter(int layoutResId, @Nullable List<AdressCar> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, AdressCar adressCar) {
        baseViewHolder.setText(R.id.user_name,adressCar.getUsername());
        baseViewHolder.setText(R.id.user_phone,adressCar.getUserphone());
        baseViewHolder.setText(R.id.user_adress,adressCar.getAdress());
        RadioButton radioButton = baseViewHolder.getView(R.id.user_check);
        radioButton.setChecked(adressCar.getIsCheck());
        addChildClickViewIds(R.id.user_edit);
        addChildClickViewIds(R.id.user_delete);
        addChildClickViewIds(R.id.user_check);
    }
}
