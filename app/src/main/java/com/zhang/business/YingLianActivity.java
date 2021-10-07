package com.zhang.business;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.unionpay.UPPayAssistEx;
import com.unionpay.uppay.PayActivity;

public class YingLianActivity extends AppCompatActivity {
    String url;
    private String mPayCode;
    private Button yinglianPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ying_lian);
        yinglianPay = (Button) findViewById(R.id.yinglian_pay);
        url = "http://101.231.204.84:8091/sim/getacptn";//银联提供的测试接口,实际开发中应使用自己公司的服务器地址接口
        yinglianPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(YingLianActivity.this, "调用了银联支付", Toast.LENGTH_SHORT).show();
                pay();
            }
        });
    }


    public void pay() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mPayCode = s;
                //3.调用SDK**：调用第三方支付SDK支付方法，传入支付串码
                //mode —— 银联后台环境标识，“00”将在银联正式环境发起交易,“01”将在银联测试环境发起交易
                UPPayAssistEx.startPayByJAR(YingLianActivity.this,
                        PayActivity.class,
                        null,
                        null,
                        mPayCode,
                        "01");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        queue.add(request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg = null;
        /** 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消*/
        String str = data.getExtras().getString("pay_result");
        if (str.equalsIgnoreCase("success")) {
            msg = "支付成功！";
        } else if (str.equalsIgnoreCase("fail")) {
            msg = "支付失败！";
        } else if (str.equalsIgnoreCase("cancel")) {
            msg = "用户取消了支付";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}