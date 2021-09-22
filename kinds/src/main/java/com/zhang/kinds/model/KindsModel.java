package com.zhang.kinds.model;

import com.zhang.kinds.net.api.KindsApi;
import com.zhang.kinds.net.entitiy.Category;
import com.zhang.kinds.net.req.ReqCategory;
import com.zhang.kinds.net.http.RetrofitFactory;
import com.zhang.mvp_core.model.IModel;


import io.reactivex.Observable;

/**
 * @ClassName KindsModel
 * @Author 孔晨亮
 * @Date 2021/9/14 8:36
 * User: msi
 */
public class KindsModel implements IModel {

    public Observable<Category> getKinds(int parentId) {
//        KindsApi kindsApi = RetrofitFactory.getRetrofitFactory().create(KindsApi.class);
        return  RetrofitFactory.getRetrofitFactory().create(KindsApi.class).getCategory(new ReqCategory(parentId));
    }
}
