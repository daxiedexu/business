package com.zhang.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;

import com.zhang.common.utils.page.TextSwitcherAnimation;
import com.zhang.home.mvp.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    private TextSwitcher fgHomeTextSwitcher;
    @Override
    public int bandLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        fgHomeTextSwitcher = (TextSwitcher) findViewById(R.id.fg_home_textSwitcher);
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        //实现文字广告
        for (int i = 0; i < 10; i++) {
            list.add(String.format("这是我循环的第%d条数据...",i));
        }
        fgHomeTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(getActivity());
                tv.setOnClickListener(view->{
                    Toast.makeText(getActivity(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                });
                return tv;
            }
        });
        new TextSwitcherAnimation(list, fgHomeTextSwitcher).create();
    }
}