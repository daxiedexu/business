package com.zhang.home.data;

import com.zhang.home.GetGoodsListByKeywordReq;

import com.zhang.home.goods.entity.BaseResp;

import com.zhang.home.goods.entity.Goods;

import com.zhang.mvp_core.model.IModel;
import com.zhang.net.commerce.RetrofitManger;

import java.util.ArrayList;

import io.reactivex.Observable;


/**
 * @ClassName GoodsModel
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class GoodsModel implements IModel {
    public Observable<BaseResp<ArrayList<Goods>>> getGoodsList(GetGoodsListByKeywordReq req){
        GoodApi goodApi=RetrofitManger.getInstance().getRetrofit().create(GoodApi.class);
        return goodApi.getGoodsListByKeyword(req);
    }
}
