package com.citi.portfoliomanager.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @ClassName: MyLogoutSuccessHandler
 * @Description: 注销成功监听器
 * @Function List: onLogoutSuccess
 *
 * @author: xtf
 * @version:
 * @Date: 2015/8/24 14:20
 *
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    protected static final Logger logger = LogManager.getLogger(MyLogoutSuccessHandler.class);
    private static String XMU_CLIENT_LOGOUT = "http://open.xmu.edu.cn/Home/Logout";

    /**
     *
     * @Function: onLogoutSuccess
     * @Description: 注销成功
     *
     * @param request
     * @param response
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        super.handle(request, response, auth);
    }
}
