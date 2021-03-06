package com.zhang.business;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.blankj.utilcode.util.PermissionUtils;
import com.zhang.business.adapter.FragmentAdapter;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.back.ChannelUtil;
import com.zhang.common.utils.page.NoScrollViewPager;
import com.zhang.home.HomeFragment;
import com.zhang.kinds.view.KindsFragment;
import com.zhang.message.MessageFragment;
import com.zhang.person.PersonFragment;
import com.zhang.shopcar.ShopCarFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = Config.MODULE_MAIN)
public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private NoScrollViewPager actMainNoScrollViewPager;
    private BottomNavigationBar actMainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtils.permission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}).request();//请求读写权限
        initView();
        initBottom();
        String channel = ChannelUtil.getChannel(this);
        Toast.makeText(this, channel, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        actMainNoScrollViewPager = (NoScrollViewPager) findViewById(R.id.act_main_noScrollViewPager);
        actMainBottom = (BottomNavigationBar) findViewById(R.id.act_main_bottom);
        actMainBottom.setTabSelectedListener(this);
        //初始化底部导航栏
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new KindsFragment());
        fragments.add(new ShopCarFragment());
        fragments.add(new MessageFragment());
        fragments.add(new PersonFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),FragmentAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        actMainNoScrollViewPager.setScroll(false);
        actMainNoScrollViewPager.setAdapter(fragmentAdapter);
    }

    private void initBottom() {
        actMainBottom.setMode(BottomNavigationBar.MODE_FIXED);
        actMainBottom.setActiveColor(R.color.red);
        actMainBottom.setInActiveColor(R.color.black);
        actMainBottom.addItem(new BottomNavigationItem(R.drawable.onehome,"主页"))
                .addItem(new BottomNavigationItem(R.drawable.kinds,"分类"))
                .addItem(new BottomNavigationItem(R.drawable.shopcar,"购物车"))
                .addItem(new BottomNavigationItem(R.drawable.message,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.person,"我的"))
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
        actMainNoScrollViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {
    }
}