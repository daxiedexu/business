package com.zhang.person;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.tabs.TabLayout;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.MyVPAdapter;
import com.zhang.fragment.All_Fragment;
import com.zhang.fragment.Canceled_Fragment;
import com.zhang.fragment.Completed_Fragment;
import com.zhang.fragment.Confirm_Fragment;
import com.zhang.fragment.Pay_Fragment;
import com.zhang.mvp_core.view.BaseActivity;

import java.util.ArrayList;

/**
 * @ClassName OrderStatus
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/15 8:44
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */


@Route(path=Person_Config.ORDER)
public class OrderStatus extends BaseActivity {
    private TabLayout orderTab;
    private ViewPager orderVp;

    @Autowired(name=Person_Config.ORDER_KTY)
    int index;


    @Override
    protected void initData() {
        ARouter.getInstance().inject(this);
        ArrayList<String> strings=new ArrayList<>( );
        strings.add("全部");
        strings.add("待付款");
        strings.add("待收货");
        strings.add("已完成");
        strings.add("我的订单");

        ArrayList<Fragment> fragments=new ArrayList<>( );
        fragments.add(new All_Fragment());
        fragments.add(new Pay_Fragment());
        fragments.add(new Canceled_Fragment());
        fragments.add(new Completed_Fragment());
        fragments.add(new Confirm_Fragment());

        MyVPAdapter myVPAdapter=new MyVPAdapter(getSupportFragmentManager( ), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, strings, fragments);
        orderVp.setAdapter(myVPAdapter);
        orderTab.setupWithViewPager(orderVp);
        orderVp.setCurrentItem(index);

    }

    @Override
    protected void initView() {
        orderTab = (TabLayout) findViewById(R.id.order_tab);
        orderVp = (ViewPager) findViewById(R.id.order_vp);
    }

    @Override
    protected int bindLayout() {
        return R.layout.order;
    }
}
