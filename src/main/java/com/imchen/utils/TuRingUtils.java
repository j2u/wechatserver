package com.imchen.utils;

import com.imchen.domain.Article;
import com.imchen.domain.WeChatMessage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imchen on 2017/6/12.
 */
public class TuRingUtils {

    public static final int TYPE_TEXT = 100000;
    public static final int TYPE_LINK = 200000;
    public static final int TYPE_NEWS = 302000;
    public static final int TYPE_FOOD = 308000;
    public static final int TYPE_CHILDRENSING = 313000;

    public static WeChatMessage tuRingTuWeChat(String ruRingMsg) throws Exception {
        JSONObject json = new JSONObject(ruRingMsg);
        return getMsgType(json);
    }

    private static WeChatMessage getMsgType(JSONObject json) throws JSONException {
        int code= (int) json.get("code");
        JSONObject listJson;
        Article article;
        List<Article> articleList;
        WeChatMessage weChatMessage=new WeChatMessage();
        switch (code) {
            case TYPE_TEXT:
                weChatMessage.setContent((String) json.get("text"));
                break;
            case TYPE_NEWS:
                weChatMessage.setMsgType("news");
                weChatMessage.setArticleCount("1");

                //parse tuRing return list node
                listJson=new JSONObject(json.getString("list"));
                article=new Article();
                article.setTitle(listJson.getString("source"));
                article.setDescription(listJson.getString("article"));
                article.setPicUrl(listJson.getString("icon"));
                article.setUrl(listJson.getString("detailurl"));

                articleList=new ArrayList<>();
                articleList.add(article);
                weChatMessage.setArticles(articleList);
                break;
            case TYPE_LINK:
                weChatMessage.setMsgType("news");
                weChatMessage.setArticleCount("1");

                //parse tuRing return list node
                article=new Article();
                article.setTitle(json.getString("text"));
                article.setDescription(json.getString("text"));
                article.setUrl(json.getString("url"));

                articleList=new ArrayList<>();
                articleList.add(article);
                weChatMessage.setArticles(articleList);
                break;
            case TYPE_FOOD:
                weChatMessage.setMsgType("news");
                weChatMessage.setArticleCount("1");

                //parse tuRing return list node
                listJson=new JSONObject(json.getString("list"));
                article=new Article();
                article.setTitle(listJson.getString("title"));
                article.setDescription(listJson.getString("info"));
                article.setPicUrl(listJson.getString("icon"));
                article.setUrl(listJson.getString("detailurl"));

                articleList=new ArrayList<>();
                articleList.add(article);
                weChatMessage.setArticles(articleList);
                break;
            case TYPE_CHILDRENSING:
                break;
            default:
                weChatMessage.setContent((String) json.get("text"));
                break;
        }
        return weChatMessage;
    }
}
