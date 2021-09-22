package com.zhang.kinds.net.api;

import com.zhang.kinds.net.entitiy.Category;
import com.zhang.kinds.net.entitiy.Goods;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.net.req.ReqCategory;
import com.zhang.kinds.net.req.ReqGoodsList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @ClassName KindsApi
 * @Author 孔晨亮
 * @Date 2021/9/14 8:29
 * User: msi
 */
public interface KindsApi {

//    @GET("api/GoodsType/getRecommendTypes")
//    Observable<KindsEntitiy> kinds();
    @POST("category/getCategory")
    Observable<Category>  getCategory(@Body ReqCategory req);
//    @POST("goods/getGoodsList")
//    Observable<Goods>  getGoodsList(@Body ReqGoodsList req);

}
