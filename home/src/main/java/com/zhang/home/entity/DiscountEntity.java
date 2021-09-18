package com.zhang.home.entity;

/**
 * @ClassName DiscountEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/17 16:21
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class DiscountEntity {
    private String discountUrl;

    public DiscountEntity() {
    }

    public DiscountEntity(String discountUrl) {
        this.discountUrl = discountUrl;
    }

    public String getDiscountUrl() {
        return discountUrl;
    }

    public void setDiscountUrl(String discountUrl) {
        this.discountUrl = discountUrl;
    }
}
