package com.zhang.shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.zhang.net.AdressCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.AdressCarDao;

import java.util.List;

public class AdressActivity extends AppCompatActivity {

    private RecyclerView adressRv;
    private Button adressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);
        initView();
        AdressCarDao adressCarDao = Sqlutils.getInstance().getDaoUtils(this).getAdressCarDao();
//        List<AdressCar> adressCars = adressCarDao.loadAll();

    }

    private void initView() {
        adressRv = (RecyclerView) findViewById(R.id.adress_rv);
        adressBtn = (Button) findViewById(R.id.adress_btn);
        adressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdressActivity.this, AdressAddActivity.class);
                startActivity(intent);
            }
        });
    }
}