package com.zhang.person;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bw.testphoto.Test;
import com.zhang.common.utils.Config;
import com.zhang.mvp_core.view.BaseFragment;

import java.util.ServiceLoader;

public class PersonFragment extends BaseFragment {
    private ImageView personImg;

    @Override
    public int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView() {
        personImg = (ImageView) getActivity().findViewById(R.id.person_img);
    }

    @Override
    public void initData() {
        personImg.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK );
                intent.setType("*/*");
                startActivityForResult(intent, Config.INTENT_PHOTO);
            }
        });
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
}