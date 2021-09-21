package com.zhang.home.goods.entity;

/**
 * @ClassName BaseResp
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/19 10:54
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class BaseResp<T> {
    private int status;
    private T data;
    private String message;

    public BaseResp(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
