package com.citi.portfoliomanager.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;

/**
 * @ClassName: MySessionRegistry
 * @Description: TODO
 * @Function List: TODO
 * @author: xtf
 * @version:
 * @Date: 2015/9/9 14:05
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class MySessionRegistry extends SessionRegistryImpl {

    protected static final Logger logger = LogManager.getLogger(MySessionRegistry.class);
    public MySessionRegistry() {
        super();
    }

    @Override
    public void removeSessionInformation(String sessionId) {
        SessionInformation info = this.getSessionInformation(sessionId);
        if(info != null) {
            User user = (User) info.getPrincipal();
            logger.info("注销的用户名为：" + user.getUsername());
        }
        super.removeSessionInformation(sessionId);
    }
}
