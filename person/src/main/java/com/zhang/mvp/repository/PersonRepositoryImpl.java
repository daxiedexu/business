package com.zhang.mvp.repository;

import com.zhang.data.protocol.RegisterReq;
import com.zhang.mvp.model.PersonModel;
import com.zhang.mvp_core.model.BaseRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.http.Body;

/**
 * @ClassName PersonRepositoryImpl
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 19:21
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class PersonRepositoryImpl extends BaseRepository {
    @Inject
    public PersonRepositoryImpl() {
    }
    public Observable<String> register(@Body RegisterReq req){
        return ((PersonModel)super.getModel("kinds")).register(req);
    }
}
