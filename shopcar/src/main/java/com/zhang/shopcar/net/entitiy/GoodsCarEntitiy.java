package com.zhang.shopcar.net.entitiy;

/**
 * @ClassName GoodsCarEntitiy
 * @Author 孔晨亮
 * @Date 2021/9/23 9:37
 * User: msi
 */
public class GoodsCarEntitiy {
    private int id; //购物车单项商品ID
    private int goodsId;//具体商品ID
    private String goodsDesc;//商品描述
    private String goodsIcon;//商品图片
    private Long goodsPrice;//商品价格
    private int goodsCount;//商品数量
    private String goodsSku;//商品SKU
    private Boolean isSelected;//是否选中

    public GoodsCarEntitiy(int id, int goodsId, String goodsDesc, String goodsIcon, Long goodsPrice, int goodsCount, String goodsSku, Boolean isSelected) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsDesc = goodsDesc;
        this.goodsIcon = goodsIcon;
        this.goodsPrice = goodsPrice;
        this.goodsCount = goodsCount;
        this.goodsSku = goodsSku;
        this.isSelected = isSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsIcon() {
        return goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon) {
        this.goodsIcon = goodsIcon;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
