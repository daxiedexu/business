package com.zhang.person;

/**
 * @ClassName User
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/19 10:08
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

public class User {

    public Integer id;
    public String username;
    public String pwd;
    public String sex;
    public String birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd=pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex=sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday=birthday;
    }
}
