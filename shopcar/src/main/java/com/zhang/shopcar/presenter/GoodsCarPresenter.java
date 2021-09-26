package com.zhang.shopcar.presenter;

import com.zhang.mvp_core.presenter.BasePresenter;
import com.zhang.shopcar.contract.GoodsContract;
import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;
import com.zhang.shopcar.net.resp.BaseResp;
import com.zhang.shopcar.repository.GoodsRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName GoodsCarPresenter
 * @Author 孔晨亮
 * @Date 2021/9/23 15:58
 * User: msi
 */
public class GoodsCarPresenter extends BasePresenter<GoodsRepository, GoodsContract> {
    @Inject
    public GoodsCarPresenter() {
    }
    public void showGoods(){
        rRepository.reqGoodsCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<GoodsCarEntitiy>>>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull BaseResp<List<GoodsCarEntitiy>> listBaseResp) {
                        vView.goodsSuccess(listBaseResp.getData());
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        vView.goodsFailds(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
