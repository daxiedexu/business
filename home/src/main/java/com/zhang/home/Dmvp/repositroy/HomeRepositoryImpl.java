package com.zhang.home.Dmvp.repositroy;

import com.zhang.home.Dmvp.model.HomeModel;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.GetGoodsListReq;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.model.BaseRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ClassName HomeRepositoryImpl
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 11:15
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeRepositoryImpl extends BaseRepository {
    @Inject
    public HomeRepositoryImpl() {
    }


    public Observable<BaseResp<List<Goods>>> getGoods(GetGoodsListReq req) {
        return ((HomeModel)super.getModel("home")).getGoods(req);
    }
}
