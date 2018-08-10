package com.citi.portfoliomanager.service;


import com.citi.portfoliomanager.dao.UserMapper;
import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.entity.UserExample;
import com.citi.portfoliomanager.service.IService.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hkz on 2017/4/23.
 */
@Service
public class UserService implements IUserService {
    protected static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
    	UserExample userExample=new UserExample();
    	userExample.createCriteria().andUsernameEqualTo(username);
    	List<User> res=userMapper.selectByExample(userExample);
    	if(res==null||res.size()<=0) {
    		return null;
    	}else {
             return res.get(0);
    	}
    }
}
