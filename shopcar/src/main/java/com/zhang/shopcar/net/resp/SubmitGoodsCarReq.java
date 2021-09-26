package com.zhang.shopcar.net.resp;

import com.zhang.shopcar.net.entitiy.GoodsCarEntitiy;

import java.util.List;

/**
 * @ClassName SubmitGoodsCarReq
 * @Author 孔晨亮
 * @Date 2021/9/23 15:29
 * User: msi
 */
public class SubmitGoodsCarReq {
    private List<GoodsCarEntitiy> goods;
    private Long totalPrice;

    public SubmitGoodsCarReq(List<GoodsCarEntitiy> goods, Long totalPrice) {
        this.goods = goods;
        this.totalPrice = totalPrice;
    }

    public List<GoodsCarEntitiy> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsCarEntitiy> goods) {
        this.goods = goods;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
