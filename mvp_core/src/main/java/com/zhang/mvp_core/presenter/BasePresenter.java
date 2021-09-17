package com.zhang.mvp_core.presenter;

import com.zhang.mvp_core.model.BaseRepository;
import com.zhang.mvp_core.view.IView;
import javax.inject.Inject;



/**
 * @ClassName BaseModel
 * @Author 孔晨亮
 * @Date 2021/9/3 9:59
 * User: msi
 */
public abstract class BasePresenter<R extends BaseRepository,V extends IView> implements IPresenter {
    @Inject
    protected R rRepository;
    @Inject
    protected V vView;



}
