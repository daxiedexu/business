package com.zhang.home.net.entity

/**
 * @ClassName GoodsSku
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/18 10:49
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
data class GoodsSku(
    val id: Int,
    val skuTitle: String,//SKU标题
    val skuContent: List<String>//SKU内容
)
