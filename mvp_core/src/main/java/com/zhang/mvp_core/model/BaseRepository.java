package com.zhang.mvp_core.model;



import com.zhang.common.utils.back.MVPModelException;

import java.lang.reflect.Field;

import javax.inject.Inject;

/**
 * @ClassName BaseRepository
 * @Author 孔晨亮
 * @Date 2021/9/8 19:19
 * User: msi
 */
public abstract class BaseRepository<M extends IModel> {
    @Inject
    protected M model;
}
