package com.zhang.home.net.entity;

/**
 * @ClassName NetEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/12 20:22
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NetEntity {
    private String title;
    private Integer image;

    public NetEntity(String title, Integer image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
