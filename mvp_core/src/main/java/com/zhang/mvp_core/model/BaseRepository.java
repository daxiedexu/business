package com.zhang.mvp_core.model;



import com.zhang.common.utils.back.MVPModelException;

import java.lang.reflect.Field;
import java.util.Map;

import javax.inject.Inject;

/**
 * @ClassName BaseRepository
 * @Author 孔晨亮
 * @Date 2021/9/8 19:19
 * User: msi
 */
public abstract class BaseRepository {
    @Inject
    protected Map<String,IModel> models;

    protected IModel getModel(String key){
        if (models!=null&&models.containsKey(key)){
            IModel iModel = models.get(key);
            return iModel;
        }
        return null;
    }
}
