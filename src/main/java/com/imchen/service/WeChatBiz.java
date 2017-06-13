package com.imchen.service;

import com.imchen.domain.WeChatReplyMsg;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by imchen on 2017/6/9.
 */
@Service
public interface WeChatBiz {

    String parseWeChatMessage(HttpServletRequest request);
    WeChatReplyMsg getReplyMsg(String msgId);
}
