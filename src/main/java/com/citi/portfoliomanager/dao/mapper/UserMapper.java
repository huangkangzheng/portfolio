package com.citi.portfoliomanager.dao.mapper;

import com.citi.portfoliomanager.entity.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hkz on 2017/4/23.
 */
public interface UserMapper {
    /**
     * 根据 用户名获取用户对象
     * @param username
     * @return
     */
    Person get(String username);

    Person getById(long userId);

    /**
     * 更新或插入用户信息
     * @param user
     * @return
     */
    boolean setUser(@Param("user") Person user);

}
