package com.imchen.ienum;

/**
 * Created by imchen on 2017/6/12.
 */
public enum TuRingMsgType {
    TEXT("100000"),LINK("200000"),NEWS("302000"),FOOD("308000"),CHILDRENSING("313000");

    private String msgType;
    TuRingMsgType(String msgType){
        this.msgType=msgType;
    }

    public String getMsgType(){
        return msgType;
    }
}
