package com.zhang.kinds.net.api;

import com.zhang.kinds.net.entitiy.KindsEntitiy;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @ClassName KindsApi
 * @Author 孔晨亮
 * @Date 2021/9/14 8:29
 * User: msi
 */
public interface KindsApi {

    @GET("api/GoodsType/getRecommendTypes")
    Observable<KindsEntitiy> kinds();
//    @POST("category/getCategory")
//    Observable<BaseResp<List<Category>>>  getCategory(@Body GetCategoryReq req);
}
