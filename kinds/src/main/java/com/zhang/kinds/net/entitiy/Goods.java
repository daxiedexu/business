package com.zhang.kinds.net.entitiy;

import java.util.List;

/**
 * @ClassName Goods
 * @Author 孔晨亮
 * @Date 2021/9/21 18:59
 * User: msi
 */
public class Goods {
    private int status;
    private String message;
    private List<Category.DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Category.DataBean> getData() {
        return data;
    }

    public void setData(List<Category.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int categoryId;
        private String goodsDesc;
        private String goodsDefaultIcon;
        private long goodsDefaultPrice;
        private String goodsDetailOne;
        private String goodsDetailTwo;
        private int goodsSalesCount;
        private int goodsStockCount;
        private String goodsCode;
        private String goodsDefaultSku;
        private String goodsBanner;
        private List<GoodsSku> goodsSku;
        private int maxPage;

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

        public long getGoodsDefaultPrice() {
            return goodsDefaultPrice;
        }

        public void setGoodsDefaultPrice(long goodsDefaultPrice) {
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
    }

}
