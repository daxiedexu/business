package com.zhang.data.api;
import com.zhang.data.protocol.RegisterReq;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ClassName UserApi
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 18:59
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public interface UserApi {
//    /*
//        用户注册
//     */
//    @POST("userCenter/register")
//    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>
//
//    /*
//        用户登录
//     */
//    @POST("userCenter/login")
//    fun login(@Body req:LoginReq):Observable<BaseResp<UserInfo>>


    @POST("userCenter/register")
    Observable<String> register(@Body RegisterReq req);


}
