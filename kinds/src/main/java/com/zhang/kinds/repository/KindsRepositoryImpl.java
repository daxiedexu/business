package com.zhang.kinds.repository;

import com.zhang.kinds.model.KindsModel;

import com.zhang.kinds.net.entitiy.KindsEntitiy;

import com.zhang.mvp_core.model.BaseRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @ClassName KindsRepository
 * @Author 孔晨亮
 * @Date 2021/9/14 8:42
 * User: msi
 */
public class KindsRepositoryImpl extends BaseRepository {

    @Inject
    public KindsRepositoryImpl() {
    }


    public Observable<KindsEntitiy> reqKinds() {
        return ((KindsModel)super.getModel("kinds")).getKinds();
    }
}
