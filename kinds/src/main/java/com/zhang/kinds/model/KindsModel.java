package com.zhang.kinds.model;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.net.entitiy.KindsEntitiy;

import io.reactivex.Observable;

/**
 * @ClassName KindsModel
 * @Author 孔晨亮
 * @Date 2021/9/14 8:36
 * User: msi
 */
public class KindsModel implements KindsContrant.kindsModel {
    @Override
    public Observable<KindsEntitiy> getModel() {
        return null;
    }

    @Override
    public void destory() {

    }
}
