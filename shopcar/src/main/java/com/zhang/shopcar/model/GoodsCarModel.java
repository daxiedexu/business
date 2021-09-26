package com.zhang.shopcar.model;

import com.zhang.mvp_core.model.IModel;
import com.zhang.net.commerce.RetrofitManger;
import com.zhang.shopcar.net.api.GoodsApi;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.net.resp.BaseResp;
import java.util.List;
import io.reactivex.Observable;

/**
 * @ClassName GoodsCarModel
 * @Author 孔晨亮
 * @Date 2021/9/23 15:33
 * User: msi
 */
public class GoodsCarModel implements IModel {

    public Observable<BaseResp<List<GoodsCarEntitiy>>> getGoods(){
        return RetrofitManger.getInstance().getRetrofit().create(GoodsApi.class).goodsCar();
    }
}
