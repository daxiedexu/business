package com.zhang.common.utils.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * @ClassName NoScrollViewPager
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/11 9:11
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NoScrollViewPager extends ViewPager {
    private boolean isScroll;
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        if (isScroll){
            return super.onInterceptHoverEvent(event);
        }else {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScroll){
            return super.onTouchEvent(ev);
        }else {
            return true;
        }
    }


    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }
}
