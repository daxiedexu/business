package com.bw.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bw.testphoto.Test;

/**
 * @ClassName Glide
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/10 19:11
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class MyGlide implements Test {
    @Override
    public void cs(String uri, Context context, ImageView view) {
        Glide.with(context).load(uri).into(view);
    }

}
