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
    private String price;
    private String morePrice;

    public DiscountEntity(String discountUrl, String price, String morePrice) {
        this.discountUrl = discountUrl;
        this.price = price;
        this.morePrice = morePrice;
    }

    public String getDiscountUrl() {
        return discountUrl;
    }

    public void setDiscountUrl(String discountUrl) {
        this.discountUrl = discountUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMorePrice() {
        return morePrice;
    }

    public void setMorePrice(String morePrice) {
        this.morePrice = morePrice;
    }
}
