package com.zhang.mvp_core.injection.module;

import com.zhang.mvp_core.model.IModel;

import dagger.Module;
import dagger.Provides;

/**
 * @ClassName ModelModule
 * @Author 孔晨亮
 * @Date 2021/9/16 19:03
 * User: msi
 */
@Module
public class ModelModule {
    private IModel model;

    public ModelModule(IModel _model) {
        this.model = _model;
    }

    @Provides
    public IModel provideModel(){
        return this.model;
    }
}
