package com.zhang.home;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhang.common.utils.Config;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseFragment;

import java.util.ArrayList;

/**
 * @ClassName Car_Fragment
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 11:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

public class CarGood_Fragment extends BaseFragment {
    private Banner cargoodBan;
    private TextView cargoodName;
    private TextView cargoodPrice;
    Goods cargood;

    @Override
    protected int bindLayout() {
        return R.layout.cargood;
    }

    @Override
    protected void initData() {

        cargood=getArguments( ).getParcelable("cargood");
        setBanner();
        cargoodName.setText(cargood.getGoodsDesc());
        cargoodPrice.setText("￥"+cargood.getGoodsDefaultPrice());

    }


    @Override
    protected void initView() {
        cargoodBan = (Banner) getActivity().findViewById(R.id.cargood_ban);
        cargoodName = (TextView) getActivity().findViewById(R.id.cargood_name);
        cargoodPrice = (TextView) getActivity().findViewById(R.id.cargood_price);

    }


    @Override
    public void onStart() {
        super.onStart( );
    }

    private void setBanner() {
        ArrayList<String> strings=new ArrayList<>( );
        strings.add(cargood.getGoodsDefaultIcon());
        strings.add(cargood.getGoodsDefaultIcon());
        strings.add(cargood.getGoodsDefaultIcon());

        cargoodBan.setImages(strings);
        cargoodBan.setImageLoader(new ImageLoader( ) {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getContext()).load(path).into(imageView);
            }
        });

        cargoodBan.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        cargoodBan.setBannerStyle(BannerConfig.RIGHT);
        cargoodBan.start();
    }
}
