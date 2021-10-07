package com.zhang.shopcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.mvp_core.view.BaseMVPActivity;
import com.zhang.net.ShopCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.DaoSession;
import com.zhang.net.db.ShopCarDao;
import com.zhang.shopcar.adapter.PayAdapter;
import com.zhang.shopcar.contract.GoodsContract;
import com.zhang.shopcar.di.component.DaggerGoodsComponent;
import com.zhang.shopcar.di.component.DaggerPayComponent;
import com.zhang.shopcar.di.module.GoodsViewModule;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.presenter.GoodsCarPresenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PayActivity extends BaseMVPActivity implements GoodsContract {
    @Inject
    GoodsCarPresenter goodsCarPresenter;
    private LinearLayout payAddress;
    private TextView payName;
    private TextView payPhone;
    private RecyclerView payRv;
    private TextView payPrice;
    private Button payBtn;
    ArrayList<ShopCar> shopList;
    int price=0;
    private ImageView back;
    private TextView tv;

    @Override
    protected void injectCompoent() {
        DaggerPayComponent.builder().activityComponent(activityComponent)
                .goodsViewModule(new GoodsViewModule(this))
                .build().injectGoods(this);
    }

    @Override
    protected void initData() {
        goodsCarPresenter.showGoods();
    }
//
//    @Subscribe
//    public void postShopList(ArrayList<ShopCar> shopCars){
//        for (int i = 0; i < shopCars.size(); i++) {
//            shopList.add(shopCars.get(i));
//        }
//    }

    @Override
    protected void initView() {
        payAddress = (LinearLayout) findViewById(R.id.pay_address);
        payName = (TextView) findViewById(R.id.pay_name);
        payPhone = (TextView) findViewById(R.id.pay_phone);
        payRv = (RecyclerView) findViewById(R.id.pay_rv);
        payPrice = (TextView) findViewById(R.id.pay_price);
        payBtn = (Button) findViewById(R.id.pay_btn);
        shopList = new ArrayList<>();
        DaoSession daoUtils = Sqlutils.getInstance().getDaoUtils(this);
        ShopCarDao shopCarDao = daoUtils.getShopCarDao();
        List<ShopCar> shopCars = shopCarDao.loadAll();
        for (int i = 0; i < shopCars.size(); i++) {
            if (shopCars.get(i).getIsCheck()){
                shopList.add(shopCars.get(i));
            }
        }
        PayAdapter payAdapter = new PayAdapter(R.layout.item_pay, shopList);
        payRv.setAdapter(payAdapter);
        payRv.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < shopList.size(); i++) {
            price+=shopList.get(i).getPrice();
        }
        payPrice.setText(price+"");
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this, ShopCarActivity.class);
                startActivity(intent);
            }
        });
        payAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this, AdressActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_pay;
    }


    @Override
    public void goodsSuccess(List<GoodsCarEntitiy> goods) {

    }

    @Override
    public void goodsFailds(Throwable throwable) {

    }
}