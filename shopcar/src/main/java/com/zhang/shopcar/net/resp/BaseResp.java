package com.zhang.shopcar.net.resp;

/**
 * @ClassName BaseResp
 * @Author 孔晨亮
 * @Date 2021/9/23 9:40
 * User: msi
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
