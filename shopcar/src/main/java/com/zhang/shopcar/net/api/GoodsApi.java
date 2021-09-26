package com.zhang.shopcar.net.api;

import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.net.resp.AddGoodsCarReq;
import com.zhang.shopcar.net.resp.BaseResp;
import com.zhang.shopcar.net.resp.DelGoodsCarReq;
import com.zhang.shopcar.net.resp.SubmitGoodsCarReq;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ClassName Api
 * @Author 孔晨亮
 * @Date 2021/9/23 9:31
 * User: msi
 */
public interface GoodsApi {
    /*
        获取购物车列表
     */
    @POST("cart/getList")
    Observable<BaseResp<List<GoodsCarEntitiy>>> goodsCar();
    /*
        添加商品到购物车
     */
    @POST("cart/add")
    Observable<BaseResp<Integer>> addGoods(@Body AddGoodsCarReq add);
    /*
        删除购物车商品
     */
    @POST("cart/delete")
    Observable<BaseResp<String>> deleteGoods(@Body DelGoodsCarReq delete);
    /*
        提交购物车商品
     */
    @POST("cart/submit")
    Observable<BaseResp<Integer>> submitGoods(@Body SubmitGoodsCarReq submit);

}
