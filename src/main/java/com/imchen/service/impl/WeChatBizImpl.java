package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.domain.WeChatMessage;
import com.imchen.domain.WeChatReplyMsg;
import com.imchen.mapper.WeChatRPMsgMapper;
import com.imchen.properties.TuLingProperties;
import com.imchen.service.WeChatBiz;
import com.imchen.utils.HttpUtil;
import com.imchen.utils.TuRingUtils;
import com.imchen.utils.WeChatUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.imchen.utils.HttpUtil.saxRequest;

/**
 * Created by imchen on 2017/6/9.
 */
@Service
public class WeChatBizImpl implements WeChatBiz {

    @Autowired
    TuLingProperties tuLingProperties;
    @Autowired
    WeChatRPMsgMapper weChatRPMsgMapper;

    Logger logger= LoggerFactory.getLogger(WeChatBizImpl.class);

    @Override
    public String parseWeChatMessage(HttpServletRequest request) {
        String responseContent = null;
        try {
            WeChatMessage message = WeChatUtil.parseXml(HttpUtil.saxRequest(request));

            String result=tuRingChat(message.getContent());//把微信的text類型信息交給TuRing Api解析
            WeChatMessage tuRingMsg= TuRingUtils.tuRingTuWeChat(result);
            tuRingMsg.setToUserName(message.getFromUserName());
            tuRingMsg.setFromUserName(message.getToUserName());
            tuRingMsg.setMsgType(message.getMsgType());
            tuRingMsg.setCreateTime(System.currentTimeMillis()+"");
            responseContent = WeChatUtil.makeTextModel(tuRingMsg);
            logger.info("response content:" + responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }


    public WeChatReplyMsg getReplyMsg(String msgId){
        return weChatRPMsgMapper.getByMsgId(msgId);
    }

    /**
     * TuRing api 聊天接口
     *
     * @param msg 聊天內容
     * @return String
     */
    private String tuRingChat (String msg) {
        HttpResponse responser = null;
        try {
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put(tuLingProperties.getParam1(), tuLingProperties.getKey());
            paramsMap.put(tuLingProperties.getParam2(), msg);
            responser = HttpUtil.send(tuLingProperties.getUrl(), "POST", paramsMap, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responser.getContent();
    }
}
