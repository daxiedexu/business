package com.zhang.shopcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhang.net.AdressCar;
import com.zhang.net.ShopCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.AdressCarDao;
import com.zhang.net.db.DaoSession;
import com.zhang.net.db.ShopCarDao;
import com.zhang.shopcar.adapter.PayAdapter;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity{

    private LinearLayout payAddress;
    private TextView payName;
    private TextView payPhone;
    private RecyclerView payRvs;
    private TextView payPrice;
    private Button payBtn;
    private ArrayList<ShopCar> shopList;
    int price=0;
    private ImageView back;
    private  PayAdapter payAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytwo);
        initView();

        DaoSession daoUser = Sqlutils.getInstance().getDaoUser(this);
        AdressCarDao adressCarDao = daoUser.getAdressCarDao();
        List<AdressCar> adressCars = adressCarDao.loadAll();
        for (int i = 0; i < adressCars.size(); i++) {
            if (adressCars.get(i).getIsCheck()){
                String username = adressCars.get(i).getUsername();
                String userphone = adressCars.get(i).getUserphone();
                payName.setText(username);
                payPhone.setText(userphone);

            }
        }
        DaoSession daoUtils = Sqlutils.getInstance().getDaoUtils(this);
        ShopCarDao shopCarDao = daoUtils.getShopCarDao();
        List<ShopCar> shopCars = shopCarDao.loadAll();
        shopList = new ArrayList<>();
        for (int i = 0; i < shopCars.size(); i++) {
            if (shopCars.get(i).getIsCheck()){
                shopList.add(shopCars.get(i));
            }
        }

        payAdapter = new PayAdapter(R.layout.item_pay, shopList);
        payRvs.setAdapter(payAdapter);
        payRvs.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        for (int i = 0; i < shopList.size(); i++) {
            price+=shopList.get(i).getPrice();
        }
        payPrice.setText(price+"");
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

    protected void initView() {
        payAddress = (LinearLayout) findViewById(R.id.pay_address);
        payName = (TextView) findViewById(R.id.pay_name);
        payPhone = (TextView) findViewById(R.id.pay_phone);
        payRvs = (RecyclerView) findViewById(R.id.pay_shop_rv);
        payPrice = (TextView) findViewById(R.id.pay_price);
        payBtn = (Button) findViewById(R.id.pay_btn);
        back = (ImageView) findViewById(R.id.back);
    }

}