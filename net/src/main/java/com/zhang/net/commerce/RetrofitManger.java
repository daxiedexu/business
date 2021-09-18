package com.zhang.net.commerce;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName RetrofitManger
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 10:00
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class RetrofitManger {
    private Retrofit retrofit;
    public void create(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://39.98.153.96:8088/shopapi/")
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new CustomInterceptor())
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .writeTimeout(2, TimeUnit.SECONDS)
                        .readTimeout(2,TimeUnit.SECONDS)
                        .connectTimeout(2,TimeUnit.SECONDS)
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        if (retrofit==null){
            create();
        }
        return retrofit;
    }

    //TODO 单例动态双重锁
    private static volatile RetrofitManger retrofitManger;
    public static RetrofitManger getInstance(){
        if (retrofitManger==null){
            synchronized (RetrofitManger.class){
                if (retrofitManger==null){
                    retrofitManger = new RetrofitManger();
                }
            }
        }
        return retrofitManger;
    }
}
