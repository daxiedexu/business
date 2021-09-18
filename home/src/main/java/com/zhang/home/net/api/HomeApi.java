package com.zhang.home.net.api;

import com.zhang.home.net.entity.BaseResp;
import com.zhang.home.net.entity.GetGoodsListReq;
import com.zhang.home.net.entity.Goods;

import java.util.ArrayList;

import io.reactivex.Observer;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ClassName HomeApi
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 10:50
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeApi {
    @POST("goods/getGoodsList")
    Observer<BaseResp<ArrayList<Goods>>> getGoods(@Body GetGoodsListReq getGoodsListReq);
}
