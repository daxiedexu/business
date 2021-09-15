package com.zhang.kinds.repository;

import android.util.Log;

import com.zhang.kinds.contrant.KindsContrant;
import com.zhang.kinds.model.KindsModel;
import com.zhang.kinds.net.di.DaggerKindsComponent;
import com.zhang.kinds.net.entitiy.KindsEntitiy;
import com.zhang.mvp_core.model.BaseRepository;
import com.zhang.net.Bean.BaseRespEntity;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ClassName KindsRepository
 * @Author 孔晨亮
 * @Date 2021/9/14 8:42
 * User: msi
 */
public class KindsRepositoryImpl extends KindsContrant.kindesRepository {

    @Inject
    KindsModel kindsModel;

    @Override
    public Observable<KindsEntitiy> reqKinds() {
        DaggerKindsComponent.create().inject(this);

        return kindsModel.getKinds();
    }
}
