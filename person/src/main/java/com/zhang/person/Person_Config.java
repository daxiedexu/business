package com.zhang.person;

/**
 * @ClassName Person_Config
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/15 8:39
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Person_Config {

    public final static String ORDER="/person/order";
    public final static String ORDER_KTY="order_key";

    /**
     * 全部
     * 待支付
     * 待收货
     * 已完成
     * 已取消
     */
    public final static Integer ORDER_ALL=0;
    public final static Integer ORDER_WAIT_PAY=1;
    public final static Integer ORDER_WAIT_CONFIRM=2;
    public final static Integer ORDER_COMPLETED=3;
    public final static Integer ORDER_CANCELED=4;
}
