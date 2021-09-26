package com.zhang.person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.testphoto.Test;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.back.SharedManger;
import com.zhang.mvp_core.view.BaseFragment;

import java.util.ServiceLoader;

public class PersonFragment extends BaseFragment implements View.OnClickListener {
    private ImageView personImg;
    private TextView personPay;
    private TextView personWait;
    private TextView personCompleted;
    private TextView personOrder;
    Intent intent;
    private TextView personLogin;
    public static Context context;
    @Override
    public int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView() {
        context=getContext();
        personImg = (ImageView) getActivity().findViewById(R.id.person_img);
        personPay = (TextView) getActivity().findViewById(R.id.person_pay);
        personWait = (TextView) getActivity().findViewById(R.id.person_wait);
        personCompleted = (TextView) getActivity().findViewById(R.id.person_completed);
        personOrder = (TextView) getActivity().findViewById(R.id.person_order);
        personLogin = (TextView) getActivity().findViewById(R.id.person_login);
    }

    @Override
    public void initData() {


        personImg.setOnClickListener(this::onClick);
        personPay.setOnClickListener(this::onClick);
        personWait.setOnClickListener(this::onClick);
        personCompleted.setOnClickListener(this::onClick);
        personOrder.setOnClickListener(this::onClick);
        personLogin.setOnClickListener(this::onClick);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            ServiceLoader<Test> serviceLoader = ServiceLoader.load(Test.class);
            // 执行不同厂商的业务实现，具体根据业务需求配置
            for (Test helloSPI : serviceLoader) {
                helloSPI.setCircular(data.getData( ).toString(),getContext(),personImg);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.person_img){
            intent=new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("*/*");
            startActivityForResult(intent, Config.INTENT_PHOTO);
        }else if (v.getId()==R.id.person_pay){
            ARouter.getInstance().build(Person_Config.ORDER)
                    .withInt(Person_Config.ORDER_KTY,Person_Config.ORDER_WAIT_PAY)
                    .navigation(getContext(),new MyNavigationCallback());
        }else if (v.getId()==R.id.person_wait){
            ARouter.getInstance().build(Person_Config.ORDER)
                    .withInt(Person_Config.ORDER_KTY,Person_Config.ORDER_WAIT_CONFIRM)
                    .navigation(getContext(),new MyNavigationCallback());
        }else if (v.getId()==R.id.person_completed){
            ARouter.getInstance().build(Person_Config.ORDER)
                    .withInt(Person_Config.ORDER_KTY,Person_Config.ORDER_COMPLETED)
                    .navigation(getContext(),new MyNavigationCallback());
        }else if (v.getId()==R.id.person_order){
            ARouter.getInstance().build(Person_Config.ORDER)
                    .withInt(Person_Config.ORDER_KTY,Person_Config.ORDER_MY)
                    .navigation(getContext(),new MyNavigationCallback());
        }else if (v.getId()==R.id.person_login){
            ARouter.getInstance().build(Person_Config.LOGIN).greenChannel().navigation();
        }
    }


    public class MyNavigationCallback implements NavigationCallback{
        @Override
        public void onFound(Postcard postcard) {

        }

        @Override
        public void onLost(Postcard postcard) {

        }

        @Override
        public void onArrival(Postcard postcard) {

        }

        @Override
        public void onInterrupt(Postcard postcard) {
            ARouter.getInstance().build(Person_Config.LOGIN).greenChannel().navigation();
        }
    }


    @Override
    public void onResume() {
        super.onResume( );
        SharedManger user=new SharedManger(getContext(), "user");
        SharedPreferences sharedPreferences=user.getSharedPreferences( );
        String zh=sharedPreferences.getString("zh", null);
        boolean isLogin=sharedPreferences.getBoolean("isLogin", false);
        if(isLogin){
            personLogin.setText(zh);
        }
    }
}