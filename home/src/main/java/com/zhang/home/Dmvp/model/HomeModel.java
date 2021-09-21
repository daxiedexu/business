package com.zhang.home.Dmvp.model;

import com.zhang.home.goods.api.HomeApi;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.GetGoodsListReq;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.model.IModel;
import com.zhang.net.commerce.RetrofitManger;


import java.util.List;

import io.reactivex.Observable;

/**
 * @ClassName HomeModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 10:25
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeModel implements IModel {
    public Observable<BaseResp<List<Goods>>> getGoods(GetGoodsListReq req){
        HomeApi homeApi = RetrofitManger.getInstance().getRetrofit().create(HomeApi.class);
        return (Observable<BaseResp<List<Goods>>>) homeApi.getGoods(req);
    }
}
