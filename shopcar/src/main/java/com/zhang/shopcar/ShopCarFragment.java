package com.zhang.shopcar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseMVPFragment;
import com.zhang.net.ShopCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.DaoSession;
import com.zhang.net.db.ShopCarDao;
import com.zhang.shopcar.contract.GoodsContract;
import com.zhang.shopcar.di.component.DaggerGoodsComponent;
import com.zhang.shopcar.di.module.GoodsViewModule;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.presenter.GoodsCarPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import ren.qinc.numberbutton.NumberButton;

public class ShopCarFragment extends BaseMVPFragment implements GoodsContract {


    @Inject
    GoodsCarPresenter goodsCarPresenter;
    private RecyclerView shopCarRv;
    private CheckBox shopCheck;
    private TextView tv;
    private TextView shopPrice;
    private Button shopBtn;

    @Override
    protected void injectComponent() {
        DaggerGoodsComponent.builder().fragmentComponent(fragmentComponent)
                .goodsViewModule(new GoodsViewModule(this))
                .build().injectGoods(this);
    }

    @Override
    public void goodsSuccess(List<GoodsCarEntitiy> goods) {
        Log.i("123456", "goodsSuccess: aaa" + goods.size());

    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_shop_car;
    }

    @Override
    protected void initData() {
        goodsCarPresenter.showGoods();
    }

    @Override
    protected void initView() {

        shopCarRv = (RecyclerView) getActivity().findViewById(R.id.shopCar_rv);
        shopCheck = (CheckBox) getActivity().findViewById(R.id.shop_check);
        tv = (TextView) getActivity().findViewById(R.id.tv);
        shopPrice = (TextView) getActivity().findViewById(R.id.shop_price);
        shopBtn = (Button) getActivity().findViewById(R.id.shop_btn);
        DaoSession daoUtils = Sqlutils.getInstance().getDaoUtils(getActivity());
        ShopCarDao shopCarDao = daoUtils.getShopCarDao();
        List<ShopCar> shopCars = shopCarDao.loadAll();
        Log.i("123456", "goodsSuccess: aaaaaa" + shopCars.size());

        ShopAdapter shopAdapter = new ShopAdapter(R.layout.item_shop, shopCars);
        shopCarRv.setAdapter(shopAdapter);
        shopCarRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shopCarRv.addItemDecoration(new DividerItemDecoration(getActivity(), 1));



        shopAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                Toast.makeText(getActivity(), ""+shopCars.get(position).getIsCheck(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), ""+shopCars.get(position).getNum(), Toast.LENGTH_SHORT).show();

            }
        });
        shopAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick( BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.shop_check) {
                    Toast.makeText(getActivity(), shopCars.get(position).getNum()+"aa", Toast.LENGTH_SHORT).show();
                    if (shopCars.get(position).getIsCheck()){
                        shopCars.get(position).setIsCheck(false);
                    }else{
                        shopCars.get(position).setIsCheck(true);
                    }
                    Log.d("123456", "onItemChildClick: "+shopCars.get(position).getIsCheck());
                }else  if (view.getId() == R.id.shop_number){
                    NumberButton numberButton = view.findViewById(R.id.shop_number);
                    shopCars.get(position).setNum(numberButton.getNumber());
                }
            }
        });
        shopCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price=0;
                if (shopCheck.isChecked()){
                    for (int i = 0; i < shopCars.size(); i++) {
                        shopCars.get(i).setIsCheck(true);
                        shopAdapter.notifyDataSetChanged();
                        price+=shopCars.get(i).getPrice();
                    }
                    shopPrice.setText(price+"");
                }else {
                    for (int i = 0; i < shopCars.size(); i++) {
                        shopCars.get(i).setIsCheck(false);
                        shopAdapter.notifyDataSetChanged();
                    }
                    shopPrice.setText(0+"");
                }

            }
        });
    }

    @Override
    public void goodsFailds(Throwable throwable) {

    }
}