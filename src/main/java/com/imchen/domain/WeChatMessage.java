package com.imchen.domain;

import java.util.List;

/**
 * Created by imchen on 2017/6/9.
 */
public class WeChatMessage {

    private Integer id;
    private List<Article> articles;
    private String ArticleCount;//图文消息个数，限制为8条以内
    private String CreateTime; //消息创建时间
    private String Content;//text message content
    private String Description; //消息描述
    private String FromUserName; //发送方帐号（一个OpenID）
    private String Format; //media format
    private String Location_X; //地理位置维度
    private String Location_Y; //地理位置经度
    private String Label; //地理位置信息
    private String MsgId; //消息id，64位整型
    private String MsgType; //消息类型(link,location,shortvideo,video,voice,image,text)
    private String MediaId;//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String PicUrl; //pricture url
    private String Recognition; //语音识别结果，UTF8编码
    private String Scale; //地图缩放大小
    private String Title; //消息标题
    private String ToUserName; //开发者微信号
    private String Url; //消息链接
    private String ThumbMediaId; //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String replyTime;//
    private String ip;//

    public WeChatMessage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "WeChatMessage{" +
                "id=" + id +
                ", articles=" + articles +
                ", ArticleCount='" + ArticleCount + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", Content='" + Content + '\'' +
                ", Description='" + Description + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", Format='" + Format + '\'' +
                ", Location_X='" + Location_X + '\'' +
                ", Location_Y='" + Location_Y + '\'' +
                ", Label='" + Label + '\'' +
                ", MsgId='" + MsgId + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", MediaId='" + MediaId + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", Recognition='" + Recognition + '\'' +
                ", Scale='" + Scale + '\'' +
                ", Title='" + Title + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", Url='" + Url + '\'' +
                ", ThumbMediaId='" + ThumbMediaId + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
