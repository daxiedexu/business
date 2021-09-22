package com.zhang.home.Dmvp.contract;


import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.view.IView;

import java.util.List;

/**
 * @ClassName HomeContract
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 10:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeContract extends IView {
    void onSuccess(BaseResp<List<Goods>> resp);
    void onFail(Throwable throwable);
}
