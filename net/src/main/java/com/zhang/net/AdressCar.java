package com.zhang.net;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ClassName AdressCar
 * @Author 孔晨亮
 * @Date 2021/10/7 13:44
 * User: msi
 */
@Entity
public class AdressCar {
    @Id(autoincrement = true)
    private Long id;
    private String username;
    private String userphone;
    private String adress;
    private boolean isCheck = false;
    @Generated(hash = 1329503624)
    public AdressCar(Long id, String username, String userphone, String adress,
            boolean isCheck) {
        this.id = id;
        this.username = username;
        this.userphone = userphone;
        this.adress = adress;
        this.isCheck = isCheck;
    }
    @Generated(hash = 382117103)
    public AdressCar() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserphone() {
        return this.userphone;
    }
    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
    public String getAdress() {
        return this.adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public boolean getIsCheck() {
        return this.isCheck;
    }
    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    
}
