package com.citi.portfoliomanager.entity;

import java.io.Serializable;

/**
 * Created by hkz on 2017/4/23.
 * 父类
 */
public class User implements Serializable{

    private Long id;
    private String username; //用户名
    private String password;  //密码
    private String realName; //真实称呼
    private String userType;//管理员还是普通用户，仅仅用作页面跳转

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long applierId) {
        id = applierId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
