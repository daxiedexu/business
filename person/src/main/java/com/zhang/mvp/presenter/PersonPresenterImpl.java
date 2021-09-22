package com.zhang.mvp.presenter;

import com.zhang.data.protocol.RegisterReq;
import com.zhang.mvp.View;
import com.zhang.mvp.repository.PersonRepositoryImpl;
import com.zhang.mvp_core.presenter.BasePresenter;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Body;

/**
 * @ClassName PersonPresenterImpl
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 19:29
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class PersonPresenterImpl extends BasePresenter<PersonRepositoryImpl,View> {
    @Inject
    public PersonPresenterImpl() {
    }
    public void register(@Body RegisterReq req){
        rRepository.register(req)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>( ) {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull String s) {
                        vView.kindsSuccess(s);
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
