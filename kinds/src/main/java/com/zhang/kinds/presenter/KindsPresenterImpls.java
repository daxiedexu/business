package com.zhang.kinds.presenter;

import com.zhang.kinds.KindsFragment;
import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.kinds.repository.KindsRepositoryImpl;
import com.zhang.mvp_core.presenter.BasePresenter;

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
public class KindsPresenterImpls  {


//    public KindsPresenterImpls(KindsContrant.kindsRepository repository, KindsContrant.KindsView vView) {
//        super(repository, vView);
//    }
//
//    @Override
//    public void showKinds() {
//        rRepository.reqKinds()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<KindsEntitiy>() {
//                    @Override
//                    public void onSubscribe( Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(KindsEntitiy kindsEntitiyBaseRespEntity) {
//                        vView.kindsSuccess(kindsEntitiyBaseRespEntity);
//                    }
//
//                    @Override
//                    public void onError( Throwable e) {
//                        vView.kindsFailds(e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

}