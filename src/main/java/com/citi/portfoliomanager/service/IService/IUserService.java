package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.User;

import java.util.List;

/**
 * Created by hkz on 2017/4/23.
 */
public interface IUserService {
    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     */
    User getUser(String username);

}
