package com.zhang.person;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.testphoto.Test;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseFragment;

import java.util.ServiceLoader;

public class PersonFragment extends BaseFragment implements View.OnClickListener {
    private ImageView personImg;
    private TextView personPay;
    private TextView personWait;
    private TextView personCompleted;
    private TextView personOrder;
    Intent intent;


    @Override
    public int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView() {
        personImg = (ImageView) getActivity().findViewById(R.id.person_img);
        personPay = (TextView) getActivity().findViewById(R.id.person_pay);
        personWait = (TextView) getActivity().findViewById(R.id.person_wait);
        personCompleted = (TextView) getActivity().findViewById(R.id.person_completed);
        personOrder = (TextView) getActivity().findViewById(R.id.person_order);
    }

    @Override
    public void initData() {
        personImg.setOnClickListener(this::onClick);
        personPay.setOnClickListener(this::onClick);
    }

    @Override
    public void initInject() {

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
            ARouter.getInstance().build(Person_Config.ORDER).withInt(Person_Config.ORDER_KTY,Person_Config.ORDER_WAIT_PAY).navigation();
        }else if (v.getId()==R.id.person_wait){

        }else if (v.getId()==R.id.person_completed){

        }else if (v.getId()==R.id.person_order){

        }
    }
}