package com.imchen.service.impl;

import com.imchen.service.WeChatBiz;
import com.imchen.utils.HttpUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.imchen.utils.HttpUtil.saxRequest;

/**
 * Created by imchen on 2017/6/9.
 */
@Service
public class WeChatBizImpl implements WeChatBiz{
    @Override
    public String parseWeChatMessage(HttpServletRequest request) {
        try {
            String msgBody=HttpUtil.saxRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
