package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.domain.WeChatMessage;
import com.imchen.domain.WeChatReplyMsg;
import com.imchen.mapper.WeChatMessageMapper;
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
    WeChatMessageMapper weChatMessageMapper;
    @Autowired
    WeChatRPMsgMapper weChatRPMsgMapper;

    Logger logger = LoggerFactory.getLogger(WeChatBizImpl.class);

    @Override
    public String chat(HttpServletRequest request) {
        //保存回复信息
        WeChatMessage msg=parseWeChatMessage(request);
        weChatRPMsgMapper.insert(msg);
        return WeChatUtil.makeTextModel(msg);
    }

    @Override
    public WeChatReplyMsg getReplyMsg(String msgId) {
        return weChatRPMsgMapper.getByMsgId(msgId);
    }

    /**
     *
     * @param request 微信服务器请求过来的request
     * @return 返回生成的WeChatMessage
     */
    public WeChatReplyMsg parseWeChatMessage(HttpServletRequest request) {
        WeChatReplyMsg replyMsg=null;
        try {
            WeChatMessage recMsg = WeChatUtil.parseXml(HttpUtil.saxRequest(request));
            //保存ip信息
            recMsg.setIp(request.getRemoteAddr());
            //保存消息
            saveRecMsg(recMsg);
            //把微信的text類型信息交給TuRing Api解析
            replyMsg = TuRingUtils.tuRingTuWeChat(startTuRingChat(recMsg.getContent()));
            replyMsg.setToUserName(message.getFromUserName());
            replyMsg.setFromUserName(message.getToUserName());
            replyMsg.setMsgType(message.getMsgType());
            replyMsg.setCreateTime(System.currentTimeMillis() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replyMsg;
    }


    /**
     * TuRing api 聊天接口
     *
     * @param msg 聊天內容
     * @return String
     */
    private String startTuRingChat(String msg) {
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



    /**
     * 在線程中保存收到來自微信服務器的信息
     * @param weChatMessage
     */
    private void saveRecMsg(WeChatMessage weChatMessage){
        new Thread(new Runnable() {
            @Override
            public void run() {
                weChatMessageMapper.insert(weChatMessage);
            }
        }).start();
    }

    /**
     * 在線程中保存收到來自微信服務器的信息
     * @param replyMsg 回覆給微信的消息
     */
    private void saveReplyMsg(WeChatReplyMsg replyMsg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                weChatRPMsgMapper.insert(replyMsg);
            }
        }).start();
    }
}
