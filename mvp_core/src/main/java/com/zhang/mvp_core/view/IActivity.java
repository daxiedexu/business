package com.zhang.mvp_core.view;

/**
 * @ClassName IActivity
 * @Author 孔晨亮
 * @Date 2021/9/3 10:01
 * User: msi
 */
public interface IActivity {
    int bindLayout();
    void initView();
    void initData();
    //dagger注入对象
    void initInject();
}
