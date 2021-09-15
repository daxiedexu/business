package com.zhang.net;

import android.text.TextUtils;
import android.util.Log;

import com.zhang.net.Bean.TokenRespEntity;
import com.zhang.net.api.TokenApi;
import com.zhang.net.common.NetConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName RetrofitFactory
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/9 10:09
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class RetrofitFactory {
    private volatile static RetrofitFactory retrofitFactory;
    public static RetrofitFactory getRetrofitFactory(){
        if(retrofitFactory  ==  null){
            synchronized (RetrofitFactory.class){
                retrofitFactory = new RetrofitFactory();
            }
        }
        return retrofitFactory;
    }
    private Retrofit retrofit;

    public RetrofitFactory() {
        retrofit=createRetrofit();
    }

    private Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://39.98.153.96:8082/")
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * OkHttpClient
     * @return
     */
    private OkHttpClient createOkHttpClient() {
        OkHttpClient build=new OkHttpClient.Builder( )
                .addInterceptor(createInterceptor())
                .addInterceptor(createNetworkInterceptor())
                .readTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .writeTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .connectTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .build( );

        return build;
    }

    private String mToken="";
    private Interceptor createNetworkInterceptor() {
        Interceptor interceptor = new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request( );
                //获取本地Token
                String localToken = mToken;
                if(!TextUtils.isEmpty(localToken)){
                    return resetRequest(request,localToken,chain);
                }

                Response proceed=chain.proceed(request);

                if(proceed.code()==401){
                    Log.i("123", "intercept: 401");
                    String token=requestToken();
                    if(TextUtils.isEmpty(token)){
                        Log.i("123", "intercept: 402");
                        return proceed;
                    }
                    mToken=token;
                    Log.i("123", "intercept: 402"+mToken);

                    return resetRequest(request,token,chain);
                }

                return proceed;
            }
        };
        return interceptor;
    }

    private String requestToken() {
        TokenApi tokenApi=create(TokenApi.class);
        Call<TokenRespEntity> password=tokenApi.getToken("password", NetConfig.AUTH_CODE, "");
        try {
            retrofit2.Response<TokenRespEntity> execute=password.execute( );
            if(execute!=null&&execute.body()!=null){
                Log.i("123", "requestToken: "+execute.body().getAccess_token());
                return execute.body().getAccess_token();
            }


        } catch (IOException e) {
            e.printStackTrace( );

        }
        return null;
    }

    private Response resetRequest(Request request, String localToken, Interceptor.Chain chain) {

        Request authorization=request.newBuilder( ).addHeader("Authorization", "bearer " + localToken).build( );
        try {
            return chain.proceed(authorization);
        } catch (IOException e) {
            e.printStackTrace( );
        }
        return null;
    }


    /**
     * 网络拦截器
     * TokenInterceptor
     * @return
     */
    private Interceptor createInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor( )
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    /**
     * 通过api接口获取到其实例
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service) ;
    }

}
