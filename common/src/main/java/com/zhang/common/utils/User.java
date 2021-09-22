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
    private String user_name;
    private int user_pwd;
    @Generated(hash = 380122259)
    public User(String user_name, int user_pwd) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getUser_name() {
        return this.user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public int getUser_pwd() {
        return this.user_pwd;
    }
    public void setUser_pwd(int user_pwd) {
        this.user_pwd = user_pwd;
    }

}
