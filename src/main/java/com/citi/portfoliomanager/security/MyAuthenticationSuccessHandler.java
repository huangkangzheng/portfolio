package com.citi.portfoliomanager.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyAuthenticationSuccessHandler
 * @Description: 登录验证成功监听器
 * @Function List: onAuthenticationSuccess
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
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    protected static final Logger logger = LogManager.getLogger(MyAuthenticationSuccessHandler.class);
    /**
     *
     * @Function: onAuthenticationSuccess
     * @Description: 验证登录成功
     *
     * @param request
     * @param response
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth) throws IOException, ServletException {
        if(auth != null) {
            MySecurityUser user = (MySecurityUser)auth.getPrincipal();
            super.onAuthenticationSuccess(request, response, auth);
            logger.info("login success");
        }

    }
}
