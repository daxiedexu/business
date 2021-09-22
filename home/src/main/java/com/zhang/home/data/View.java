package com.zhang.home.data;

import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.IView;

import java.util.ArrayList;

/**
 * @ClassName View
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:14
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public interface View extends IView {
    void onGetGoodsListResult(ArrayList<Goods> result);
}
