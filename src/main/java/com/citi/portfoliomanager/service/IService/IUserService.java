package com.citi.portfoliomanager.service.IService;

import com.citi.portfoliomanager.entity.Person;
import com.citi.portfoliomanager.entity.TResource;

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
    Person getUser(String username);

    /**
     * 获取网站所有的资源集
     *
     * @return
     */
    List<TResource> getAllResources();

    /**
     * 根据用户名获取该用户的资源集
     *
     * @param roleId
     * @return
     */
    List<TResource> getResourcesByRoleId(long roleId);

    /**
     * 更新用户
     * @param user
     * @return
     */

}
