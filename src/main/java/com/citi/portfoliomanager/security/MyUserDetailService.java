package com.citi.portfoliomanager.security;


import com.citi.portfoliomanager.entity.Person;
import com.citi.portfoliomanager.entity.TResource;
import com.citi.portfoliomanager.service.IService.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: MyUserDetailService
 * @Description: Security登录验证服务
 * @Function List: loadUserByUsername，transferUser
 *
 * @author: xtf
 * @version:
 * @Date: 2015/8/10 14:20
 *
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MyUserDetailService implements UserDetailsService {
    protected static final Logger logger = LogManager.getLogger(MyUserDetailService.class);

    private IUserService userService;

    public MyUserDetailService() {}

    @Autowired
    public MyUserDetailService(IUserService userService)
    {
        this.userService = userService;
    }

    /**
     *
     * @Function: loadUserByUsername
     * @Description: 验证登录用户
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("begin authorization");
        Person user = userService.getUser(username);
        return transferUser(user);
    }

    /**
     *
     * @Function: transferUser
     * @Description: 转换Tuser为spring-security自带的User对象(实现了UserDetails接口)
     *
     * @param user
     * @return
     */
    public User transferUser(Person user) {
        if (user != null && StringUtils.isNotBlank(user.getPassword()) && user.getRole() != null) { //防止添加某个用户的时候，该用户密码还没入库，结果用户进来了
            //从缓存中获取用户资源
            List<TResource> resources = userService.getResourcesByRoleId(user.getRole().getId());
            //再转换资源对象
            Set<GrantedAuthority> authoritySet = new HashSet<GrantedAuthority>();
            if(CollectionUtils.isNotEmpty(resources)) {
                for (TResource resource : resources) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(resource.getAttribute());
                    authoritySet.add(authority);
                }
                logger.info("" + user + "resources:[size=" + resources.size() + ",contents=" + resources + "]");
            }
            MySecurityUser securityUser = new MySecurityUser(user.getId(), user.getUsername(), user.getPassword(),
                    user.getUserType(), user.getRealName(), authoritySet);//参数是正确的密码
            return securityUser;
        }

        logger.info("Doesn't exist the username");
        //如果用户名不存在时候,抛出异常
        throw new UsernameNotFoundException("Doesn't exist the username");

    }

}

