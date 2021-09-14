package com.zhang.mvp_core.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.zhang.mvp_core.model.BaseRepository;
import com.zhang.mvp_core.view.IView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;


/**
 * @ClassName BaseModel
 * @Author 孔晨亮
 * @Date 2021/9/3 9:59
 * User: msi
 */
public abstract class BasePresenter<R extends BaseRepository,V extends IView> implements IPresenter {
    protected R rRepository;
    protected V vView;

    public BasePresenter(R repository, V vView) {
        this.rRepository = repository;
        this.vView = vView;
    }

    @Override
    public void destory() {
        if (rRepository!=null){
            rRepository=null;
        }
        if (vView!=null){
            vView=null;
        }
    }


}
