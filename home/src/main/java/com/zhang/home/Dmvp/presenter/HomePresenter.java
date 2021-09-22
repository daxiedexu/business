package com.zhang.home.Dmvp.presenter;

import com.zhang.home.Dmvp.contract.HomeContract;
import com.zhang.home.Dmvp.repositroy.HomeRepositoryImpl;
import com.zhang.home.goods.entity.BaseResp;
import com.zhang.home.goods.entity.GetGoodsListReq;
import com.zhang.home.goods.entity.Goods;
import com.zhang.mvp_core.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName HomePresenter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 11:15
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomePresenter extends BasePresenter<HomeRepositoryImpl, HomeContract> {
    @Inject
    public HomePresenter() {
    }

    public void getGoods(GetGoodsListReq req){
        rRepository.getGoods(req)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<Goods>>>(){
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull BaseResp<List<Goods>> resp) {
                        vView.onSuccess(resp);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        vView.onFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
