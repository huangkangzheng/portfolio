package com.citi.portfoliomanager.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @ClassName: MySecurityUser
 * @Description: TODO
 * @Function List: TODO
 * @author: xtf
 * @version:
 * @Date: 2015/9/6 9:42
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MySecurityUser extends User {

    private long userId; //用户id
    private String userIp; //用户ip
    private String userType; //用户类型
    private String realName;
    private String phone;
    private String email;
/*    private String college;*/

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    public MySecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    public MySecurityUser(long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
    }
    public MySecurityUser(long userId, String username, String password, String userType, String realName, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.userType = userType;
        this.realName = realName;

    }

/*    public MySecurityUser(long userId, String username, String password, String userType, String realName,String college, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.userType = userType;
        this.realName = realName;
        this.college=college;
    }*/


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 /*   public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }*/
}
