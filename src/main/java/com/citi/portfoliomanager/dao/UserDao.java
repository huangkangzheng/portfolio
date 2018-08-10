package com.citi.portfoliomanager.dao;

import com.citi.portfoliomanager.dao.mapper.UserMapper;
import com.citi.portfoliomanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hkz on 2017/4/23.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User get(String username){
        return userMapper.get(username);
    }
}
