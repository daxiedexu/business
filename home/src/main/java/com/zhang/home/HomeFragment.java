package com.zhang.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhang.common.utils.page.TextSwitcherAnimation;
import com.zhang.home.adapter.NetAdapter;
import com.zhang.home.entity.NetEntity;
import com.zhang.home.mvp.BaseFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    private TextSwitcher fgHomeTextSwitcher;
    private Banner fgHomeBanner;
    private MZBannerView fgHomeMzBanner;
    private RecyclerView fgHomeNet;
    List<Integer> imageList = new ArrayList<>(Arrays.asList(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e));
    @Override
    public int bandLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        fgHomeBanner = (Banner) findViewById(R.id.fg_home_banner);
        fgHomeTextSwitcher = (TextSwitcher) findViewById(R.id.fg_home_textSwitcher);
        fgHomeMzBanner = (MZBannerView) findViewById(R.id.fg_home_mzBanner);
        fgHomeNet = (RecyclerView) findViewById(R.id.fg_home_net);
        initBanner();
        initMzBanner();
        initNetRecycler();
    }

    private void initNetRecycler() {
        List<NetEntity> netEntityList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            netEntityList.add(new NetEntity("标题"+i,R.mipmap.ic_launcher_round));
        }
        NetAdapter netAdapter = new NetAdapter(netEntityList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        fgHomeNet.setAdapter(netAdapter);
        fgHomeNet.setLayoutManager(gridLayoutManager);
    }

    private void initMzBanner() {
        // 设置数据
        fgHomeMzBanner.setPages(imageList, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        fgHomeMzBanner.setIndicatorVisible(false);
    }

    class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.mz_banner,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    private void initBanner() {
        fgHomeBanner.setImages(imageList);
        fgHomeBanner.setDelayTime(2000);
        fgHomeBanner.setBannerStyle(BannerConfig.RIGHT);
        fgHomeBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageResource((Integer) path);
            }
        });
        fgHomeBanner.start();
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

    @Override
    public void onPause() {
        super.onPause();
        fgHomeBanner.stopAutoPlay();
    }

    @Override
    public void onResume() {
        super.onResume();
        fgHomeBanner.start();
    }
}