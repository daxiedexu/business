package com.zhang.common.utils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ClassName User
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/16 20:22
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Entity
public class User {
    private Integer user_name;
    private String user_pwd;
    @Generated(hash = 1161395263)
    public User(Integer user_name, String user_pwd) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Integer getUser_name() {
        return this.user_name;
    }
    public void setUser_name(Integer user_name) {
        this.user_name = user_name;
    }
    public String getUser_pwd() {
        return this.user_pwd;
    }
    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}
