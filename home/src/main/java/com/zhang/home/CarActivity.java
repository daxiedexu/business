package com.zhang.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.tabs.TabLayout;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.MyVPAdapter;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.BaseActivity;

import java.util.ArrayList;

/**
 * @ClassName CarActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/22 11:03
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Config.MODULE_CAR)
public class CarActivity extends BaseActivity {
    private ImageView carBack;
    private TabLayout carTab;
    private ViewPager carVp;

    @Autowired(name="car")
    Goods goods;
    @Override
    protected void initData() {
        ARouter.getInstance().inject(this);
        ArrayList<String> strings=new ArrayList<>( );
        strings.add("商品");
        strings.add("详情");

        ArrayList<Fragment> fragments=new ArrayList<>( );
        CarGood_Fragment carGood_fragment=new CarGood_Fragment( );
        fragments.add(carGood_fragment);
        fragments.add(new Particulars_Fragment());

        MyVPAdapter myVPAdapter=new MyVPAdapter(getSupportFragmentManager( ), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, strings, fragments);
        carVp.setAdapter(myVPAdapter);
        carTab.setupWithViewPager(carVp);

        Bundle bundle=new Bundle( );
        bundle.putParcelable("cargood",goods);
        carGood_fragment.setArguments(bundle);
    }

    @Override
    protected void initView() {
        carBack = (ImageView) findViewById(R.id.car_back);
        carTab = (TabLayout) findViewById(R.id.car_tab);
        carVp = (ViewPager) findViewById(R.id.car_vp);
    }

    @Override
    protected int bindLayout() {
        return R.layout.car;
    }
}
