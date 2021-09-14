package com.zhang.mvp_core.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.zhang.mvp_core.model.BaseRepository;
import com.zhang.mvp_core.view.IView;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;


/**
 * @ClassName BaseModel
 * @Author 孔晨亮
 * @Date 2021/9/3 9:59
 * User: msi
 */
public abstract class BasePresenter<R extends BaseRepository,V extends IView> implements IPresenter {
    protected R repository;
    protected V vView;

    public BasePresenter(R repository, V vView) {
        this.repository = repository;
        this.vView = vView;
    }

    protected List<Disposable> disposables=new ArrayList<>();
    //解除rxjava中观察者与被观察者订阅关系
    //lifecycle  观察activity或者fragment的生命周期destory方法
    //当activity或fragment进入destory时进入ondestory
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)

    @Override
    public void destory() {
        for (Disposable disposable:disposables){
            if (!disposable.isDisposed()){
                disposable.dispose();
            }
        }
    }


}
