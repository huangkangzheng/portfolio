package com.citi.portfoliomanager.security;

import com.citi.portfoliomanager.constant.DictEnum;
import com.citi.portfoliomanager.entity.Person;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;


/**
 * @ClassName: MySecurityContext
 * @Description: ISecurityService接口的实现
 * @Function List: getCurrentUser，expireUser ，listActiveUsers，getActiveUsernameList
 *
 * @author: xtf
 * @version:
 * @Date: 2015/8/26 14:20
 *
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */


public class MySecurityContext {

    private static SessionRegistry mySessionRegistry;
    private static AuthenticationManager myAuthenticationManager;
    /**
     *
     * @Function: getSecurityUser
     * @Description: 获取当前执行登录操作的MySecurityUser对象，继承自User
     *
     * @return
     */
    public static MySecurityUser getSecurityUser() {
        if(getAuthentication() == null)
            return null;
        MySecurityUser user;
        try {
           user = (MySecurityUser)getAuthentication()
                   .getPrincipal();
           user.setUserIp(getCurrentUserIp());
           return user;
        }
        catch (ClassCastException e)
        {
           return null;
        }
    }

    /**
     *
     * @Function: getCurrentUser
     * @Description: 获取当前执行登录操作的TUser对象
     *
     * @return
     */
    public static Person getCurrentUser() {
        MySecurityUser securityUser = getSecurityUser();
        if(securityUser == null)
            return null;

        Person user = new Person();
        user.setUsername(securityUser.getUsername());//用户名
        user.setId(securityUser.getUserId()); //用户id
        user.setRealName(securityUser.getRealName()); //用户id
        return user;
    }

    /**
     *
     * @Function: getCurrentUserId
     * @Description: 返回当前登录用户的id
     *
     * @return
     */
    public static long getCurrentUserId() {
        MySecurityUser user = getSecurityUser();
        if(user == null)
            return -1;
        return user.getUserId();
    }



    /**
     *
     * @Function: 判断当前用户是否登录
     * @Description: 返回当前登录用户的id
     *
     * @return
     */
    public static boolean isLogined() {
        return getSecurityUser() != null;
    }


    /**
     *
     * @Function: getCurrentUserType
     * @Description: 返回当前登录用户的类型
     *
     * @return
     */
    public static String getCurrentUserType() {
        MySecurityUser user = getSecurityUser();
        if(user == null)
            return DictEnum.PersonType.COMMON_USER;
        return user.getUserType();
    }



    /**
     *
     * @Function: getCurrentUsername
     * @Description: 返回当前登录用户的用户名,即学号
     *
     * @return
     */
    public static String getCurrentUsername() {
        Authentication authentication = getAuthentication();

        if ((authentication == null) || (authentication.getPrincipal() == null)) {
            return "";
        }
        return authentication.getName();
    }

    /**
     *
     * @Function: getCurrentUsername
     * @Description: 返回当前登录用户的真实姓名
     *
     * @return
     */
    public static String getCurrentUserRealName() {
        MySecurityUser user = getSecurityUser();
        if(user == null){
            return "";
        }
        return user.getRealName();
    }

    /**
     *
     * @Function: getCurrentUserIp
     * @Description: 返回当前登录用户的ip
     *
     * @return
     */
    public static String getCurrentUserIp() {
        Authentication authentication = getAuthentication();
        return getUserIpByAuthentication(authentication);
    }

    /**
     *
     * @Function: getUserIpByAuthentication
     * @Description: 返回当前登录用户的ip
     *
     * @return
     */
    public static String getUserIpByAuthentication(Authentication authentication) {

        if (authentication == null) {
            return "";
        }
        Object details = authentication.getDetails();

        if (!(details instanceof WebAuthenticationDetails)) {
            return "";
        }
        WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
        return webDetails.getRemoteAddress();
    }

    /**
     *
     * @Function: getCurrentUserAuthorities
     * @Description: 获取当前登录用户的资源集
     *
     * @return
     */
    public static Collection<GrantedAuthority> getCurrentUserAuthorities(){
        MySecurityUser user = getSecurityUser();
        if(user == null)
            return null;

        return user.getAuthorities();
    }


    /**
     *
     * @Function: getAuthentication
     * @Description: 获取认证对象
     *
     * @return
     */
    public static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }




    /**
     *
     * @Function: listActiveUsers
     * @Description: 获取所有在线用户
     *
     * @return
     */
    public static Map listActiveUsers() {
        Map<Object,Date> lastActivityDates = new HashMap<Object, Date>();
        for(Object principal: mySessionRegistry.getAllPrincipals()) {
            // a principal may have multiple active sessions
            for(SessionInformation session : mySessionRegistry.getAllSessions(principal, false))
            {
                // no last activity stored
                if(lastActivityDates.get(principal) == null) {
                    lastActivityDates.put(principal, session.getLastRequest());
                } else {
                    // check to see if this session is newer than the last stored
                    Date prevLastRequest = lastActivityDates.get(principal);
                    if(session.getLastRequest().after(prevLastRequest)) {
                        // update if so
                        lastActivityDates.put(principal, session.getLastRequest());
                    }
                }
            }
        }
        return lastActivityDates;
    }

    public static List<String> getActiveUsernameList() {
        List<String> activeUsers = new ArrayList<String>();
        for(Object principal:mySessionRegistry.getAllPrincipals()) {
            // a principal may have multiple active sessions
            for(SessionInformation session : mySessionRegistry.getAllSessions(principal, false))
            {
                User user = (User)principal;
                activeUsers.add(user.getUsername());
            }
        }
        return activeUsers;
    }


    /**
     *
     * @Function: expireUser
     * @Description: 踢出用户，删除实体认证及sessionId
     *
     * @param principal
     */
    public static void expireUser(Object principal) {
        List<SessionInformation> sessionInformations = mySessionRegistry.getAllSessions(principal, false);
        for(SessionInformation session : sessionInformations)
        {
            session.expireNow(); //使session过期
            mySessionRegistry.removeSessionInformation(session.getSessionId());//彻底删除sessionId
        }
    }

    /**
     *
     * @Function:  expireCurrentUser
     * @Description: 注销当前登录用户,如修改密码后让用户重新登录
     *
     */
    public static void expireCurrentUser(){
        MySecurityUser user = getSecurityUser();
        expireUser(user);
    }

    /**
     * 根据principl获取SecurityUser对象
     * @param principal
     * @return
     */
    public static MySecurityUser getSecurityUser(Principal principal){
        Object user = ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return (MySecurityUser)user;
    }

    /**
     * 手动登录
     * @param request
     * @param username
     * @param password
     */
    public static void manualLogin(HttpServletRequest request, String username, String password){
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        // Authenticate the user
        Authentication authentication = myAuthenticationManager.authenticate(authRequest);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    }


    public void setMySessionRegistry(SessionRegistry mySessionRegistry) {
        MySecurityContext.mySessionRegistry = mySessionRegistry;
    }

    public void setMyAuthenticationManager(AuthenticationManager myAuthenticationManager) {
        this.myAuthenticationManager = myAuthenticationManager;
    }
}
