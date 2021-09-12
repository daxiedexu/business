package com.bw.picasso;

import android.content.Context;
import android.widget.ImageView;

import com.bw.testphoto.Test;
import com.squareup.picasso.Picasso;

/**
 * @ClassName MyPicasso
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/11 8:17
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class MyPicasso implements Test {
    @Override
    public void cs(String uri, Context context, ImageView view) {
        Picasso.with(context).load(uri).into(view);
    }
}
