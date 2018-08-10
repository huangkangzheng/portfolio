package com.citi.portfoliomanager.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyAccessDeniedHandler
 * @Description: 访问受限监听器
 * @Function List: handle
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
public class MyAccessDeniedHandler extends AccessDeniedHandlerImpl {
    protected static Logger logger = LogManager.getLogger(MyAccessDeniedHandler.class);

    /**
     *
     * @Function: handle
     * @Description: 访问受限处理方法
     *
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logger.info(accessDeniedException.getMessage());
        super.handle(request, response, accessDeniedException);

    }
}
