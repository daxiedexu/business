package com.zhang.net.Bean;

import java.util.LinkedHashMap;

/**
 * @ClassName TokenRespEntity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/9 10:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;

    public BaseRespEntity(){}

    public BaseRespEntity(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        if (data.getClass()== LinkedHashMap.class){

        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseRespEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
