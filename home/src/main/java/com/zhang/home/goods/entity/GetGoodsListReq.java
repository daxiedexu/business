package com.zhang.home.goods.entity;

/**
 * @ClassName GetGoodsListReq
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 11:04
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class GetGoodsListReq {
    private int categoryId;
    private int pageNo;

    public GetGoodsListReq(int categoryId, int pageNo) {
        this.categoryId = categoryId;
        this.pageNo = pageNo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "GetGoodsListReq{" +
                "categoryId=" + categoryId +
                ", pageNo=" + pageNo +
                '}';
    }
}
