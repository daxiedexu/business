package com.zhang.shopcar.repository;

import com.zhang.mvp_core.model.BaseRepository;
import com.zhang.shopcar.model.GoodsCarModel;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.net.resp.BaseResp;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ClassName GoodsRepository
 * @Author 孔晨亮
 * @Date 2021/9/23 15:38
 * User: msi
 */
public class GoodsRepository extends BaseRepository {

    @Inject
    public GoodsRepository() {
    }

    public Observable<BaseResp<List<GoodsCarEntitiy>>> reqGoodsCar(){
        return ((GoodsCarModel)super.getModel("goods")).getGoods();
    }
}
