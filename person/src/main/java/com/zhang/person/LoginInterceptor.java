package com.zhang.person;

import android.content.Context;
import android.util.Log;


import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.zhang.common.utils.Config;
import com.zhang.common.utils.back.SharedManger;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/16 18:35
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Interceptor(priority=8,name="登录拦截")
public class LoginInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

            switch (postcard.getPath( )){
                case Config.MODULE_MAIN:
                case Config.MODULE_GOODS:
                case Config.MODULE_SPLASH:
                    callback.onContinue(postcard);  // 处理完成，交还控制权
                    break;
                default:
                    callback.onInterrupt(null);// 觉得有问题，中断路由流程
                    break;
        }
    }

    @Override
    public void init(Context context) {

    }
}
