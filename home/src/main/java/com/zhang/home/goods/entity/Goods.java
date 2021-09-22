package com.zhang.home.goods.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wangjiaxing
 * @date 2021/9/19
 * Description  
 */
public class Goods implements Parcelable {
    int  id  ; //商品ID
    int  categoryId  ; //分类ID
    String goodsDesc  ; //商品描述
    String  goodsDefaultIcon ; //默认图标
    Long  goodsDefaultPrice  ; //默认价格
    String  goodsDetailOne  ; //商品详情一图
    String  goodsDetailTwo  ; //商品详情二图
    int  goodsSalesCount  ; //商品销量
    int  goodsStockCount  ; //商品剩余量
    String  goodsCode  ; //商品编号
    String  goodsDefaultSku; //默认SKU
    String  goodsBanner  ; //商品banner图
    List<GoodsSku>  goodsSku; //商品SKU
    int  maxPage;//最大页码

    public Goods(int id, int categoryId, String goodsDesc, String goodsDefaultIcon, Long goodsDefaultPrice, String goodsDetailOne, String goodsDetailTwo, int goodsSalesCount, int goodsStockCount, String goodsCode, String goodsDefaultSku, String goodsBanner, List<GoodsSku> goodsSku, int maxPage) {
        this.id = id;
        this.categoryId = categoryId;
        this.goodsDesc = goodsDesc;
        this.goodsDefaultIcon = goodsDefaultIcon;
        this.goodsDefaultPrice = goodsDefaultPrice;
        this.goodsDetailOne = goodsDetailOne;
        this.goodsDetailTwo = goodsDetailTwo;
        this.goodsSalesCount = goodsSalesCount;
        this.goodsStockCount = goodsStockCount;
        this.goodsCode = goodsCode;
        this.goodsDefaultSku = goodsDefaultSku;
        this.goodsBanner = goodsBanner;
        this.goodsSku = goodsSku;
        this.maxPage = maxPage;
    }

    protected Goods(Parcel in) {
        id = in.readInt();
        categoryId = in.readInt();
        goodsDesc = in.readString();
        goodsDefaultIcon = in.readString();
        if (in.readByte() == 0) {
            goodsDefaultPrice = null;
        } else {
            goodsDefaultPrice = in.readLong();
        }
        goodsDetailOne = in.readString();
        goodsDetailTwo = in.readString();
        goodsSalesCount = in.readInt();
        goodsStockCount = in.readInt();
        goodsCode = in.readString();
        goodsDefaultSku = in.readString();
        goodsBanner = in.readString();
        maxPage = in.readInt();
    }

    public static final Creator<Goods> CREATOR = new Creator<Goods>() {
        @Override
        public Goods createFromParcel(Parcel in) {
            return new Goods(in);
        }

        @Override
        public Goods[] newArray(int size) {
            return new Goods[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDefaultIcon() {
        return goodsDefaultIcon;
    }

    public void setGoodsDefaultIcon(String goodsDefaultIcon) {
        this.goodsDefaultIcon = goodsDefaultIcon;
    }

    public Long getGoodsDefaultPrice() {
        return goodsDefaultPrice;
    }

    public void setGoodsDefaultPrice(Long goodsDefaultPrice) {
        this.goodsDefaultPrice = goodsDefaultPrice;
    }

    public String getGoodsDetailOne() {
        return goodsDetailOne;
    }

    public void setGoodsDetailOne(String goodsDetailOne) {
        this.goodsDetailOne = goodsDetailOne;
    }

    public String getGoodsDetailTwo() {
        return goodsDetailTwo;
    }

    public void setGoodsDetailTwo(String goodsDetailTwo) {
        this.goodsDetailTwo = goodsDetailTwo;
    }

    public int getGoodsSalesCount() {
        return goodsSalesCount;
    }

    public void setGoodsSalesCount(int goodsSalesCount) {
        this.goodsSalesCount = goodsSalesCount;
    }

    public int getGoodsStockCount() {
        return goodsStockCount;
    }

    public void setGoodsStockCount(int goodsStockCount) {
        this.goodsStockCount = goodsStockCount;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsDefaultSku() {
        return goodsDefaultSku;
    }

    public void setGoodsDefaultSku(String goodsDefaultSku) {
        this.goodsDefaultSku = goodsDefaultSku;
    }

    public String getGoodsBanner() {
        return goodsBanner;
    }

    public void setGoodsBanner(String goodsBanner) {
        this.goodsBanner = goodsBanner;
    }

    public List<GoodsSku> getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(List<GoodsSku> goodsSku) {
        this.goodsSku = goodsSku;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(categoryId);
        dest.writeString(goodsDesc);
        dest.writeString(goodsDefaultIcon);
        if (goodsDefaultPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(goodsDefaultPrice);
        }
        dest.writeString(goodsDetailOne);
        dest.writeString(goodsDetailTwo);
        dest.writeInt(goodsSalesCount);
        dest.writeInt(goodsStockCount);
        dest.writeString(goodsCode);
        dest.writeString(goodsDefaultSku);
        dest.writeString(goodsBanner);
        dest.writeInt(maxPage);
    }
}
