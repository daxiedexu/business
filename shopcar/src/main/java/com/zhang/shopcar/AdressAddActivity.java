package com.zhang.shopcar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AdressAddActivity extends AppCompatActivity {

    private RelativeLayout top;
    private ImageView back;
    private EditText addName;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_add);
        initView();

    }

    private void initView() {
        top = (RelativeLayout) findViewById(R.id.top);
        back = (ImageView) findViewById(R.id.back);
        addName = (EditText) findViewById(R.id.add_name);
        addBtn = (Button) findViewById(R.id.add_btn);
    }
}