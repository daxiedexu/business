package com.zhang.shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zhang.net.AdressCar;
import com.zhang.net.Sqlutils;
import com.zhang.net.db.AdressCarDao;

public class AdressAddActivity extends AppCompatActivity {

    private ImageView back;
    private EditText addName;
    private Button addBtn;
    private RelativeLayout top;
    private EditText addPhone;
    private EditText addAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_add);
        initView();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdressCarDao adressCarDao = Sqlutils.getInstance().getDaoUser(AdressAddActivity.this).getAdressCarDao();
                AdressCar adressCar = new AdressCar();
                adressCar.setUsername(addName.getText().toString());
                adressCar.setAdress(addAdress.getText().toString());
                adressCar.setUserphone(addPhone.getText().toString());
                adressCarDao.insert(adressCar);
                Toast.makeText(AdressAddActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdressAddActivity.this, AdressActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        addName = (EditText) findViewById(R.id.add_name);
        addBtn = (Button) findViewById(R.id.add_btn);
        top = (RelativeLayout) findViewById(R.id.top);
        addPhone = (EditText) findViewById(R.id.add_phone);
        addAdress = (EditText) findViewById(R.id.add_adress);
    }
}