package com.imchen.controller;

import com.imchen.utils.WeChatUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imchen on 2017/6/8.
 */
@RestController
public class WeChatController {

    @RequestMapping(value = "/wechat",method = RequestMethod.GET)
    public String validWeChatInfo(@RequestParam(value = "signature") String signature,@RequestParam("timestamp") String timesteamp,
                                  @RequestParam(value = "nonce") String nonce,@RequestParam("echostr") String echostr){
        if (WeChatUtil.checkSignature(signature,timesteamp,nonce)){
            return echostr;
        }else {
            return null;
        }
    }
}
