package com.zhang.home;

/**
 * @ClassName GetGoodsListByKeywordReq
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/21 20:03
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

/*
    按关键字搜索商品
 */
public class GetGoodsListByKeywordReq {
    public GetGoodsListByKeywordReq(String keyword, int pageNo) {
        this.keyword=keyword;
        this.pageNo=pageNo;
    }

    private  String keyword;
    private  int pageNo;
}
