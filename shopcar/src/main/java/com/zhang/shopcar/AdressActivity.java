package com.zhang.shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhang.net.AdressCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.AdressCarDao;
import com.zhang.net.db.DaoSession;
import com.zhang.shopcar.adapter.AdressAdapter;

import java.util.List;

public class AdressActivity extends AppCompatActivity {

    private RecyclerView adressRv;
    private Button adressBtn;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);
        initView();
        DaoSession daoUtils = Sqlutils.getInstance().getDaoUser(this);
        AdressCarDao adressCarDao = daoUtils.getAdressCarDao();
        List<AdressCar> adressCars = adressCarDao.loadAll();
        Log.i("123456", "onCreate: " + adressCars.size());
        AdressAdapter adressAdapter = new AdressAdapter(R.layout.item_adress, adressCars);
        adressRv.setAdapter(adressAdapter);
        adressRv.setLayoutManager(new LinearLayoutManager(this));

        adressAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.user_check) {
                    for (int i = 0; i < adressCars.size(); i++) {
                        AdressCar adressCar = new AdressCar();
                        adressCar.setUsername(adressCars.get(i).getUsername());
                        adressCar.setUserphone(adressCars.get(i).getUserphone());
                        adressCar.setAdress(adressCars.get(i).getAdress());
                        adressCar.setId(adressCars.get(i).getId());
                        adressCar.setIsCheck(false);
                        adressCarDao.update(adressCar);

                        adressCars.get(i).setIsCheck(false);
                    }
                    AdressCar adressCar = new AdressCar();
                    adressCar.setUsername(adressCars.get(position).getUsername());
                    adressCar.setUserphone(adressCars.get(position).getUserphone());
                    adressCar.setAdress(adressCars.get(position).getAdress());
                    adressCar.setId(adressCars.get(position).getId());
                    adressCar.setIsCheck(true);
                    adressCarDao.update(adressCar);
                    adressCars.get(position).setIsCheck(true);
                    adressAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initView() {
        adressRv = (RecyclerView) findViewById(R.id.adress_rv);
        adressBtn = (Button) findViewById(R.id.adress_btn);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdressActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });
        adressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdressActivity.this, AdressAddActivity.class);
                startActivity(intent);
            }
        });

    }
}