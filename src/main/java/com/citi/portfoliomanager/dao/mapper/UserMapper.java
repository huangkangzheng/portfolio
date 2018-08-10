package com.citi.portfoliomanager.dao.mapper;

import com.citi.portfoliomanager.entity.User;

/**
 * Created by hkz on 2017/4/23.
 */
public interface UserMapper {
    User get(String username);
}
