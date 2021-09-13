package com.zhang.net.api;

import com.zhang.net.Bean.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ClassName TokenApi
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/9 10:53
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
