package com.zhang.common.utils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * @ClassName MyVPAdapter
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/15 20:35
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class MyVPAdapter extends FragmentPagerAdapter {
    ArrayList<String> strings;
    ArrayList<Fragment> fragments;

    public MyVPAdapter(FragmentManager fm, int behavior, ArrayList<String> strings, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.strings=strings;
        this.fragments=fragments;
    }

    public MyVPAdapter(FragmentManager fm, int behavior, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.fragments=fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
