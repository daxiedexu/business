package com.zhang.home.data;

import com.zhang.home.GetGoodsListByKeywordReq;
import com.zhang.home.Goods;
import com.zhang.home.data.GoodsModel;
import com.zhang.mvp_core.model.BaseRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.http.Body;

/**
 * @ClassName GoodsRepository
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:06
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class GoodsRepository extends BaseRepository {

    @Inject
    public GoodsRepository() {
    }
    public Observable<ArrayList<Goods>> getGoodsList(@Body GetGoodsListByKeywordReq req){
        return ((GoodsModel)super.getModel("goods")).getGoodsList(req);
    }
}
