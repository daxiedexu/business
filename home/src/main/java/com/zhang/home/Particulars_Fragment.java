package com.zhang.home;

import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseFragment;

/**
 * @ClassName Particulars_Fragment
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 11:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Particulars_Fragment extends BaseFragment {

    private ImageView parImg1;
    private ImageView parImg2;



    @Override
    protected int bindLayout() {
        return R.layout.particulars;
    }

    @Override
    protected void initData() {
        Goods cargood=getArguments( ).getParcelable("cargood");
        Glide.with(getActivity()).load(cargood.getGoodsDetailOne()).into(parImg1);
        Glide.with(getActivity()).load(cargood.getGoodsDetailTwo()).into(parImg2);
    }

    @Override
    protected void initView() {
        parImg1 = (ImageView) getActivity().findViewById(R.id.par_img1);
        parImg2 = (ImageView) getActivity().findViewById(R.id.par_img2);
    }
}
