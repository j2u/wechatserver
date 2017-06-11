package com.imchen.service.impl;

import com.imchen.domain.WeChatMessage;
import com.imchen.service.WeChatBiz;
import com.imchen.utils.HttpUtil;
import com.imchen.utils.WeChatUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

import static com.imchen.utils.HttpUtil.saxRequest;

/**
 * Created by imchen on 2017/6/9.
 */
@Service
public class WeChatBizImpl implements WeChatBiz {
    @Override
    public String parseWeChatMessage(HttpServletRequest request) {
        String responseContent = null;
        try {
            WeChatMessage message=WeChatUtil.parseXml(HttpUtil.saxRequest(request));
            WeChatMessage answerMsg=new WeChatMessage();
            answerMsg.setToUserName(message.getFromUserName());
            answerMsg.setFromUserName(message.getToUserName());
            answerMsg.setCreateTime(System.currentTimeMillis()+"");
            answerMsg.setMsgType("text");
            answerMsg.setContent("have been recive you message:"+message.getContent());
            responseContent=WeChatUtil.makeTextModel(answerMsg);
            System.out.println("response:"+responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }
}
