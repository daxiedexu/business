package com.zhang.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.page.StatusBarColorUtils;
import com.zhang.home.Dmvp.contract.HomeContract;
import com.zhang.home.Dmvp.di.component.DaggerHomeComponent;
import com.zhang.home.Dmvp.di.module.HomeViewModule;
import com.zhang.home.Dmvp.presenter.HomePresenter;
import com.zhang.home.adapter.DiscountAdapter;
import com.zhang.home.adapter.HomeAdapter;
import com.zhang.home.adapter.NetAdapter;
import com.zhang.home.entity.DiscountEntity;
import com.zhang.home.entity.NetEntity;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.GetGoodsListReq;
import com.zhang.home.goods.entity.Goods;
import com.zhang.home.width.TextSwitcherAnimation;
import com.zhang.mvp_core.view.BaseMVPFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class HomeFragment extends BaseMVPFragment implements HomeContract {
    private static final String TAG = "HomeFragment";
    private TextSwitcher fgHomeTextSwitcher;
    private Banner fgHomeBanner;
    private MZBannerView fgHomeMzBanner;
    private RecyclerView fgHomeNet;
    private TextView fgHomeSearch;
    private RecyclerView fgHomeDiscount;
    private RecyclerView fgRecyclerGoods;
    List<Integer> imageList = new ArrayList<>(Arrays.asList(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e));
    @Inject
    HomePresenter homePresenter;
    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        fgHomeBanner = (Banner) getActivity().findViewById(R.id.fg_home_banner);
        fgHomeTextSwitcher = (TextSwitcher) getActivity().findViewById(R.id.fg_home_textSwitcher);
        fgHomeMzBanner = (MZBannerView) getActivity().findViewById(R.id.fg_home_mzBanner);
        fgHomeNet = (RecyclerView) getActivity().findViewById(R.id.fg_home_net);
        fgHomeSearch = (TextView) getActivity().findViewById(R.id.fg_home_search);
        fgHomeDiscount = (RecyclerView) getActivity().findViewById(R.id.fg_home_discount);
        fgRecyclerGoods = (RecyclerView) getActivity().findViewById(R.id.fg_recycler_goods);
    }

    private void initDiscount() {
        List<DiscountEntity> discountEntities = new ArrayList<>();
        discountEntities.add(new DiscountEntity("https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg","$2634.00","1999.00"));
        discountEntities.add(new DiscountEntity("https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg","$2234.00","1929.00"));
        discountEntities.add(new DiscountEntity("https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg","$2534.00","1999.00"));
        discountEntities.add(new DiscountEntity("https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg","$1634.00","1242.00"));
        discountEntities.add(new DiscountEntity("https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg","$2234.00","1999.00"));
        discountEntities.add(new DiscountEntity("https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg","$2834.00","1992.00"));
        DiscountAdapter discountAdapter = new DiscountAdapter(discountEntities);
        fgHomeDiscount.setAdapter(discountAdapter);
        fgHomeDiscount.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
    }

    private void initNetRecycler() {
        List<NetEntity> netEntityList = new ArrayList<>();
        netEntityList.add(new NetEntity("直播",R.drawable.zhibo));
        netEntityList.add(new NetEntity("电脑",R.drawable.dan));
        netEntityList.add(new NetEntity("手机",R.drawable.phone));
        netEntityList.add(new NetEntity("Pad",R.drawable.pad));
        netEntityList.add(new NetEntity("家居",R.drawable.jia));
        netEntityList.add(new NetEntity("家电",R.drawable.dian));
        netEntityList.add(new NetEntity("运动",R.drawable.sport));
        netEntityList.add(new NetEntity("休闲",R.drawable.xiu));
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

    @Override
    public void onSuccess(BaseResp<List<Goods>> resp) {
        HomeAdapter homeAdapter = new HomeAdapter(resp.getData());
        fgRecyclerGoods.setAdapter(homeAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        fgRecyclerGoods.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    @Override
    public void onFail(Throwable throwable) {

    }

    @Override
    protected void injectComponent() {
        DaggerHomeComponent.builder().fragmentComponent(fragmentComponent)
                .homeViewModule(new HomeViewModule(this))
                .build().injectKinds(this);
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
        initBanner();
        initMzBanner();
        initDiscount();
        initNetRecycler();
        List<String> list = new ArrayList<>();
        //实现文字广告
        list.add("夏日炎炎，第一波福利还有30秒到达战场");
        list.add("新用户立领1000元优惠券");
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
        //点击跳转Activity
        fgHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Config.MODULE_SEARCH).greenChannel().navigation();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        homePresenter.getGoods(new GetGoodsListReq(14,1));
        int parseColor = Color.parseColor("#FF8800");
        StatusBarColorUtils.setStatusBarColor(getActivity(),parseColor);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(getActivity(),false);
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

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}