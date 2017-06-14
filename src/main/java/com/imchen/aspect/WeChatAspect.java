package com.imchen.aspect;

import com.imchen.domain.WeChatReplyMsg;
import com.imchen.mapper.WeChatRPMsgMapper;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA2017.1.2.
 * Author: imchen
 * Date: 2017/6/14
 * Time: 14:24
 */
@Aspect
@Component
public class WeChatAspect {

    Logger logger= LoggerFactory.getLogger(WeChatAspect.class);

    @Autowired
    WeChatRPMsgMapper weChatRPMsgMapper;

    @Pointcut(" execution(public * com.imchen.service..*.*(..))")
    public void wechatMsgAspect() {
    }

    @Before(value = "wechatMsgAspect()")
    public void doMethodBefore() {
        logger.info("starting parseWeChatMessage..");
    }

    @AfterReturning(returning = "ret", pointcut = "wechatMsgAspect()")
    public void doMethodAfterReturning(Object ret) {
        WeChatReplyMsg msg= (WeChatReplyMsg) ret;
        System.out.println(msg.toString());
//        weChatRPMsgMapper.insert();
    }
}
