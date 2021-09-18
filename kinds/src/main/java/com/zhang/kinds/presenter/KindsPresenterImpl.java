package com.zhang.kinds.presenter;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.repository.KindsRepositoryImpl;
import com.zhang.mvp_core.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName KindsPresenter
 * @Author 孔晨亮
 * @Date 2021/9/14 8:43
 * User: msi
 */
public class KindsPresenterImpl  extends BasePresenter<KindsRepositoryImpl, KindsContrant> {
    @Inject
    public KindsPresenterImpl() {
    }

    public void showKinds(){
        rRepository.reqKinds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KindsEntitiy>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull KindsEntitiy kindsEntitiy) {
                        vView.kindsSuccess(kindsEntitiy);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        vView.kindsFailds(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
