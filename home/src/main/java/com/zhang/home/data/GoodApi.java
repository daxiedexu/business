package com.zhang.home.data;

import com.zhang.home.GetGoodsListByKeywordReq;

import com.zhang.home.goods.entity.BaseResp;

import com.zhang.home.goods.entity.Goods;


import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ClassName GoodApi
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:01
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public interface GoodApi {
//    /*
//        获取商品列表
//     */
//    @POST("goods/getGoodsList")
//    fun getGoodsList(@Body req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>
//
//    /*
//        获取商品列表
//     */
//    @POST("goods/getGoodsListByKeyword")
//    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Observable<BaseResp<MutableList<Goods>?>>

    @POST("goods/getGoodsListByKeyword")
    Observable<BaseResp<ArrayList<Goods>>> getGoodsListByKeyword(@Body GetGoodsListByKeywordReq req);

}
