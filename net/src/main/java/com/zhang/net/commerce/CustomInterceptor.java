package com.zhang.net.commerce;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @ClassName CustomInterceptor
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 10:04
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class CustomInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("token", "123456").build());
    }
}
