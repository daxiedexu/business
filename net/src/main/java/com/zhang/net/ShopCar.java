package com.zhang.net;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ClassName ShopCar
 * @Author 孔晨亮
 * @Date 2021/9/23 19:52
 * User: msi
 */
@Entity
public class ShopCar {
    @Id(autoincrement = true)
    private Long id;
    private String goodsname;
    private String goodsmsg;
    private String pic;
    private float price;
    private int num;
    private boolean isCheck = false;
    @Generated(hash = 959304965)
    public ShopCar(Long id, String goodsname, String goodsmsg, String pic,
            float price, int num, boolean isCheck) {
        this.id = id;
        this.goodsname = goodsname;
        this.goodsmsg = goodsmsg;
        this.pic = pic;
        this.price = price;
        this.num = num;
        this.isCheck = isCheck;
    }
    @Generated(hash = 1637372148)
    public ShopCar() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGoodsname() {
        return this.goodsname;
    }
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
    public String getGoodsmsg() {
        return this.goodsmsg;
    }
    public void setGoodsmsg(String goodsmsg) {
        this.goodsmsg = goodsmsg;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public boolean getIsCheck() {
        return this.isCheck;
    }
    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

}
