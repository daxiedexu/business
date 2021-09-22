package com.zhang.home.width;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * @ClassName HomeDecoration
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/21 18:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeDecoration extends Y_DividerItemDecoration {
    public HomeDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        return new Y_DividerBuilder()
                .setLeftSideLine(true,0xff666666,1,0,0)
                .setRightSideLine(true,0xff666666,1,0,0)
                .setTopSideLine(true,0xff666666,1,0,0)
                .setBottomSideLine(true,0xff666666,1,0,0)
                .create();
    }
}
