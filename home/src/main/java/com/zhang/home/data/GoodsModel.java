package com.zhang.home.data;

import com.zhang.home.GetGoodsListByKeywordReq;
import com.zhang.home.Goods;
import com.zhang.home.data.GoodApi;
import com.zhang.mvp_core.model.IModel;
import com.zhang.net.RetrofitFactory;
import com.zhang.net.commerce.RetrofitManger;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Body;

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
    public Observable<ArrayList<Goods>> getGoodsList(@Body GetGoodsListByKeywordReq req){
        GoodApi goodApi=RetrofitManger.getInstance().getRetrofit().create(GoodApi.class);
        return goodApi.getGoodsListByKeyword(req);
    }
}
