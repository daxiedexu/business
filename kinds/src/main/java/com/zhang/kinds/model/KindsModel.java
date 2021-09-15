package com.zhang.kinds.model;

import android.util.Log;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.api.KindsApi;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.net.Bean.BaseRespEntity;
import com.zhang.net.RetrofitFactory;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ClassName KindsModel
 * @Author 孔晨亮
 * @Date 2021/9/14 8:36
 * User: msi
 */
public class KindsModel implements KindsContrant.KindsModel {


    @Override
    public Observable<KindsEntitiy> getKinds() {
        KindsApi kindsApi = RetrofitFactory.getRetrofitFactory().create(KindsApi.class);
        Log.i("123456", "getKinds: 1");
        return kindsApi.kinds();
    }
}
