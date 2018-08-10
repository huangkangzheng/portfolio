package com.citi.portfoliomanager.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: MyFilterSecurityInterceptor
 * @Description: 登录拦截器
 * @Function List: doFilter，invoke,obtainSecurityMetadataSource
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
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor  implements Filter {
    protected static final Logger logger = LogManager.getLogger(MyFilterSecurityInterceptor.class);
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    /**
     *
     * @Function: doFilter
     * @Description: 登陆后，每次访问资源都通过这个拦截器拦截
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("begin to do filter");
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }


    /**
     *
     * @Function: invoke
     * @Description: fi里面有一个被拦截的url
     *里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
     *再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
     *
     * @param fi
     * @throws IOException
     * @throws ServletException
     */
    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    /**
     *
     * @Function: getSecurityMetadataSource
     * @Description:获取权限资源提供者
     *
     * @return
     */
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    /**
     *
     * @Function: setSecurityMetadataSource
     * @Description: 设置权限资源提供者
     *
     * @param newSource
     */
    public void setSecurityMetadataSource(
            FilterInvocationSecurityMetadataSource newSource)
    {
        this.securityMetadataSource = newSource;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    @Override
    public Class<? extends Object> getSecureObjectClass() {
        return FilterInvocation.class;
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    @Override
    public void destroy() {

    }

}