package com.zhang.kinds.model;

import com.zhang.kinds.net.api.KindsApi;
import com.zhang.kinds.net.entitiy.KindsEntitiy;

import com.zhang.mvp_core.model.IModel;
import com.zhang.net.RetrofitFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * @ClassName KindsModel
 * @Author 孔晨亮
 * @Date 2021/9/14 8:36
 * User: msi
 */
public class KindsModel implements IModel {

    public Observable<KindsEntitiy> getKinds() {
        KindsApi kindsApi = RetrofitFactory.getRetrofitFactory().create(KindsApi.class);
//        RetrofitFactory.Companion.getInstance().create(KindsApi.class).getCategory(new GetCategoryReq(parentId))
        return kindsApi.kinds();
    }
}
