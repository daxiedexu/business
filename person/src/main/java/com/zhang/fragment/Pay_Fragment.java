package com.zhang.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhang.adapter.PayAdapters;
import com.zhang.mvp_core.view.BaseFragment;
import com.zhang.net.ShopCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.ShopCarDao;
import com.zhang.person.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @ClassName Pay_Fragment
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/15 15:20
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Pay_Fragment extends BaseFragment {
    private RecyclerView rvPay;

    @Override
    protected int bindLayout() {
        return R.layout.pay;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        rvPay = (RecyclerView) getActivity().findViewById(R.id.rv_pay);
        ShopCarDao shopCarDao = Sqlutils.getInstance().getDaoUtils(getActivity()).getShopCarDao();
        List<ShopCar> shopCars = shopCarDao.loadAll();
        PayAdapters payAdapters = new PayAdapters(R.layout.item_pays, shopCars);
        rvPay.setAdapter(payAdapters);
        rvPay.setLayoutManager(new LinearLayoutManager(getActivity()));

        payAdapters.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                if (view.getId()==R.id.pay_btn_pay){

                }
            }
        });

    }
}
