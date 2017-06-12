package com.imchen.utils;

import com.imchen.domain.WeChatMessage;
import com.imchen.ienum.TuRingMsgType;
import org.json.JSONObject;

/**
 * Created by imchen on 2017/6/12.
 */
public class TuRingUtils {

    public static WeChatMessage tuRingTuWeChat(String ruRingMsg) throws Exception {
        JSONObject json=new JSONObject(ruRingMsg);
        String code= (String) json.get("code");

        return null;
    }

    private String getMsgType(){
        String a=TuRingMsgType.valueOf("TEXT").getMsgType();
        switch (""){
            case TuRingMsgType.valueOf("TEXT").getMsgType():
                break;
        }
        return null;
    }
}
