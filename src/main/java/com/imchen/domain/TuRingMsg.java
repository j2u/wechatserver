package com.imchen.domain;

import java.util.List;

/**
 * Created by imchen on 2017/6/12.
 */
public class TuRingMsg {

    private Integer code;
    private String key;
    private String info;
    private String userId;
    private String text;
    private String url;
    private List<TuRingArticle> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TuRingArticle> getList() {
        return list;
    }

    public void setList(List<TuRingArticle> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TuRingMsg{" +
                "code=" + code +
                ", key='" + key + '\'' +
                ", info='" + info + '\'' +
                ", userId='" + userId + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }
}
