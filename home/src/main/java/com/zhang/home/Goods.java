package com.zhang.home;

import java.util.List;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 19:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Goods {
//    val id: Int,//商品ID
//    val categoryId: Int,//分类ID
//    val goodsDesc: String,//商品描述
//    val goodsDefaultIcon: String,//默认图标
//    val goodsDefaultPrice: Long,//默认价格
//    val goodsDetailOne: String,//商品详情一图
//    val goodsDetailTwo: String,//商品详情二图
//    val goodsSalesCount: Int,//商品销量
//    val goodsStockCount: Int,//商品剩余量
//    val goodsCode: String,//商品编号
//    val goodsDefaultSku: String,//默认SKU
//    val goodsBanner: String,//商品banner图
//    val goodsSku:List<GoodsSku>,//商品SKU
//    val maxPage:Int//最大页码

    private int id;
    private int categoryId;
    private String goodsDesc;
    private String goodsDefaultIcon;
    private Long goodsDefaultPrice;
    private String goodsDetailOne;
    private String goodsDetailTwo;
    private int goodsSalesCount;
    private int goodsStockCount;
    private String goodsCode;
    private String goodsDefaultSku;
    private String goodsBanner;
    private List<GoodsSku> goodsSku;
    private int maxPage;//最大页码
}
