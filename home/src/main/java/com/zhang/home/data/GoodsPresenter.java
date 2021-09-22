package com.zhang.home.data;

import com.zhang.home.GetGoodsListByKeywordReq;


import com.zhang.home.goods.entity.BaseResp;

import com.zhang.home.goods.entity.Goods;

import com.zhang.mvp_core.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @ClassName GoodsPresenter
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:12
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class GoodsPresenter extends BasePresenter<GoodsRepository,View> {

    @Inject
    public GoodsPresenter() {
    }


    public void getGoodsList(GetGoodsListByKeywordReq req){
        rRepository.getGoodsList(req)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<ArrayList<Goods>>>( ) {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull BaseResp<ArrayList<Goods>> arrayListBaseResp) {
                        vView.onGetGoodsListResult(arrayListBaseResp);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
