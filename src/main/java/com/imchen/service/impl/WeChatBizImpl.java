package com.imchen.service.impl;

import com.imchen.domain.HttpResponse;
import com.imchen.domain.WeChatMessage;
import com.imchen.properties.TuLingProperties;
import com.imchen.service.WeChatBiz;
import com.imchen.utils.HttpUtil;
import com.imchen.utils.WeChatUtil;
import org.json.JSONObject;
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

    @Override
    public String parseWeChatMessage(HttpServletRequest request) {
        String responseContent = null;
        try {
            WeChatMessage message = WeChatUtil.parseXml(HttpUtil.saxRequest(request));
            WeChatMessage answerMsg = new WeChatMessage();
            answerMsg.setToUserName(message.getFromUserName());
            answerMsg.setFromUserName(message.getToUserName());
            answerMsg.setCreateTime(System.currentTimeMillis() + "");
            answerMsg.setMsgType("text");
            answerMsg.setContent("have been recive you message:" + message.getContent());
            responseContent = WeChatUtil.makeTextModel(answerMsg);
            System.out.println("response:" + responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }

    /**
     * use tuling api to chat with user
     *
     * @param msg
     * @return
     */
    private String tulingChat(String msg) {
        String tuLingAnswer = "";
        int code;
        HttpResponse responser = null;
        try {
            Map<String, String> paramsMap = new HashMap<>();
            JSONObject json;
            paramsMap.put(tuLingProperties.getParam1(), tuLingProperties.getKey());
            paramsMap.put(tuLingProperties.getParam2(), msg);
            responser = HttpUtil.send(tuLingProperties.getUrl(), "POST", paramsMap, null);
            json = new JSONObject(responser.getContent());
            tuLingAnswer = (String) json.get("text");
            code = (int) json.get("code");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tuLingAnswer;
    }
}
