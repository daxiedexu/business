package com.zhang.home.data;

import com.zhang.home.Goods;
import com.zhang.mvp_core.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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
    public void getGoodsList(String keyword,int pageNo){
        rRepository.getGoodsList(keyword,pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<Goods>>( ) {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull ArrayList<Goods> goods) {
                        vView.onGetGoodsListResult(goods);
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
