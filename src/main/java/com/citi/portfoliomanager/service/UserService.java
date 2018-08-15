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
    public User getUser(Integer userId) {
    
    	User res=userMapper.selectByPrimaryKey(userId);
    	return res;
    }

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		UserExample userExample=new UserExample();
    	userExample.createCriteria().andUsernameEqualTo(username);
    	List<User> res;
    	try {
    	res=userMapper.selectByExample(userExample);
    	}catch(Exception e) {
    		User user=new User();
    		user.setUserId(-400);
    		e.printStackTrace();
    		logger.error(e.getMessage());
    		return user;
    	  }
    	
    	if(res==null||res.size()<=0) {
    		User user=new User();
    		user.setUserId(-102);
    		return user;
    	}else {
             User tag= res.get(0);
             if(!tag.getPassword().equals(password)) {
            	 tag.setUserId(-101);
            	 return tag;
             }
             if(tag.getType()!=0&&tag.getType()!=1){
            	 tag.setUserId(-103);
            	 return tag;
             }
             if(tag.getStatus()!=0) {
            	 tag.setUserId(-104);
            	 return tag;
             }
             return tag;
    	}
	}
	
	public List<User> getUsers(int type){
		UserExample example=new UserExample();
		example.createCriteria().andTypeEqualTo(type).andStatusEqualTo(0);
		return userMapper.selectByExample(example);
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		if(userMapper.insert(user)==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateUser(int userId,String password) {
		// TODO Auto-generated method stub
		User user=getUser(userId);
		if(user==null) {
			return false;
		}
		user.setPassword(password);
		
		if(userMapper.updateByPrimaryKey(user)==1)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean updateUser(int userId,int status) {
		// TODO Auto-generated method stub
		User user=getUser(userId);
		if(user==null) {
			return false;
		}
		user.setStatus(status);
		if(userMapper.updateByPrimaryKey(user)==1)
			return true;
		else
			return false;
	}
	
}
