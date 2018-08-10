package com.citi.portfoliomanager.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyAuthenticationFailureHandler
 * @Description: 登录验证失败监听器
 * @Function List: onAuthenticationFailure
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
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    protected static Logger logger = LogManager.getLogger(MyAuthenticationFailureHandler.class);

    /**
     *
     * @Function: onAuthenticationFailure
     * @Description: 验证登录用户失败
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        //增加自己的处理逻辑
        logger.info("login failure,the reason is " + exception.getMessage() );
        super.onAuthenticationFailure(request, response, exception);
    }
}
