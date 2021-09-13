package com.zhang.net.Bean;

/**
 * @ClassName TokenRespEntity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/9 10:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class TokenRespEntity {
    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
