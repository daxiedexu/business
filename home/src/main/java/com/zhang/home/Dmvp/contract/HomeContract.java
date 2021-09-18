package com.zhang.home.Dmvp.contract;

import com.zhang.home.net.entity.Goods;

/**
 * @ClassName HomeContract
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 11:06
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeContract {
    void success(Goods goods);
    void fail(Throwable throwable);
}
