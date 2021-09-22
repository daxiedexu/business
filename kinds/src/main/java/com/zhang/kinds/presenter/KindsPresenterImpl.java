package com.zhang.kinds.presenter;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.Category;
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
        rRepository.reqKinds(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Category>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull Category category) {
                        vView.kindsSuccess(category);
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
    public void showComputer(){
        rRepository.reqKinds(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Category>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull Category category) {
                        vView.computerSuccess(category);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        vView.computerFailds(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void showPhone(){
        rRepository.reqKinds(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Category>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull Category category) {
                        vView.phoneSuccess(category);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        vView.phoneFailds(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
