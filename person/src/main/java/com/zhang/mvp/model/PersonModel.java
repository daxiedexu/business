package com.zhang.mvp.model;

import com.zhang.data.api.UserApi;
import com.zhang.data.protocol.RegisterReq;
import com.zhang.mvp_core.model.IModel;
import com.zhang.net.RetrofitFactory;
import io.reactivex.Observable;
import retrofit2.http.Body;

/**
 * @ClassName PersonModel
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 19:14
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class PersonModel implements IModel {
    public Observable<String> register(@Body RegisterReq req){
        UserApi userApi=RetrofitFactory.getRetrofitFactory( ).create(UserApi.class);
        return userApi.register(req);
    }
}
