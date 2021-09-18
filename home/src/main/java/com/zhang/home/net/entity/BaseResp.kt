package com.zhang.home.net.entity

/**
 * @ClassName BaseResp
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 10:47
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
data class BaseResp<out T>(val status:Int, val message:String, val data:T)