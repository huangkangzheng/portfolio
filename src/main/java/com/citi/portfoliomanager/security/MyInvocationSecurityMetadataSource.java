package com.citi.portfoliomanager.security;

import com.citi.portfoliomanager.entity.TResource;
import com.citi.portfoliomanager.service.IService.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * @ClassName: MyInvocationSecurityMetadataSource
 * @Description: 获取资源和URL对应关系
 * @Function List: loadSource，getAttributes，supports，getAllConfigAttributes
 *
 * @author: xtf
 * @version:
 * @Date: 2015/8/15 14:20
 *
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    protected static final Logger logger = LogManager.getLogger(MyInvocationSecurityMetadataSource.class);
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    private IUserService userService;


    public MyInvocationSecurityMetadataSource(){}
    /**
     *
     * @Function: MyInvocationSecurityMetadataSource
     * @Description: tomcat启动时实例化一次 加载所有url和权限（或角色）的对应关系
     *
     * @param userService
     */
    @Autowired
    public MyInvocationSecurityMetadataSource(IUserService userService){
        this.userService = userService;
        loadSource();
    }


    /**
     *
     * @Function: loadSource
     * @Description: 获取所有的url和和对应权限 1对1
     *
     */
    private void loadSource() {

        resourceMap = new LinkedHashMap<String, Collection<ConfigAttribute>>();
        List<TResource> resources = userService.getAllResources();
        if(resources != null) {
            logger.info("All ResourcesSet=[ size:" + resources.size() + " content:" + resources + "]");
            for (TResource resource : resources) {
                if (resource.getAttribute() != null) {
                    Collection<ConfigAttribute> attr = new ArrayList<ConfigAttribute>();
                    ConfigAttribute ca = new SecurityConfig(resource.getAttribute());
                    attr.add(ca);
                    resourceMap.put(resource.getUrl(), attr);
                }
            }
        }
    }




    /**
     *
     * @Function: getAttributes
     * @Description: 获取指定url资源所需要的权限
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        String url = ((FilterInvocation)object).getRequestUrl();
        int dotIndex = url.indexOf(".");//第一个位置
        if(dotIndex != -1) {
            url = url.substring(0, dotIndex);
        }
        int paramIndex = url.indexOf("?");
        if(paramIndex != -1) {
            url = url.substring(0, paramIndex);
        }
        if(url.endsWith("/")){//去掉最后一个斜杆
            int last = url.lastIndexOf("/");
            url = url.substring(0, last);
        }
        Iterator<String>ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if(resURL.equals(url)){
                logger.info("request url " + url + " needed authorities:" + resourceMap.get(resURL));
                return resourceMap.get(resURL);
            }
        }
        logger.info("request url " + url +" doesn't need any authority");
        return null;

//        String url = ((FilterInvocation)object).getRequestUrl();
//        Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
//        Set<String> allUrls = resourceMap.keySet();
//        boolean needAuthFlag = false;
//        for(String resUrl: allUrls)
//        {
//            if(AntUrlMatcher.pathMatchesUrl(resUrl, url)){
//                needAuthFlag = true;
//                attributes.addAll(resourceMap.get(resUrl));
//                logger.debug("match " + url + " includes:" + resUrl);
//            }
//
//        }
//        if(needAuthFlag)
//            return attributes;
//        else {
//            logger.debug("request url " + url +" doesn't need any authority");
//            return null;
//        }

    }

    @Override
    public boolean supports(Class<?>clazz) {
        return true;
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
