package com.zhang.kinds.repository;

import com.zhang.kinds.model.KindsModel;

import com.zhang.kinds.net.entitiy.Category;

import com.zhang.mvp_core.model.BaseRepository;

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

    public Observable<Category> reqKinds(int parentId) {
        return ((KindsModel)super.getModel("kinds")).getKinds(parentId);
    }

}
