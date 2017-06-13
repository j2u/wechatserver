package com.imchen.controller;

import com.imchen.service.WeChatBiz;
import com.imchen.utils.WeChatUtil;
import com.imchen.mapper.WeChatMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by imchen on 2017/6/8.
 */
@RestController
public class WeChatController {

    Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String validWeChatInfo(@RequestParam(value = "signature") String signature, @RequestParam("timestamp") String timesteamp,
                                  @RequestParam(value = "nonce") String nonce, @RequestParam("echostr") String echostr) {
        if (WeChatUtil.checkSignature(signature, timesteamp, nonce)) {
            return echostr;
        } else {
            return null;
        }
    }

    @Autowired
    HttpServletRequest request;
    @Autowired
    WeChatBiz weChatBiz;

    @RequestMapping(value = "/wechat", method = RequestMethod.POST)
    public String saxMessage() {
        String userAgent = request.getHeader("User-Agent");
        logger.info("The request user agent:{}",userAgent);
        return weChatBiz.parseWeChatMessage(request);
    }

    @RequestMapping(value = "/wechat/{msgId}",method = RequestMethod.GET)
    public String query(@PathVariable String msgId){
        return weChatBiz.getReplyMsg(msgId).toString();
    }
}
