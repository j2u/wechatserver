package com.imchen.domain;

/**
 * Created by imchen on 2017/6/13.
 */
public class WeChatReplyMsg {
    private Integer id;
    private String msgId;
    private String recMsgId;
    private String msgType;
    private String content;
    private String mediaId;
    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl;
    private String thumbMediaId;
    private String replyUid;

    public WeChatReplyMsg() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRecMsgId() {
        return recMsgId;
    }

    public void setRecMsgId(String recMsgId) {
        this.recMsgId = recMsgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getReplyUid() {
        return replyUid;
    }

    public void setReplyUid(String replyUid) {
        this.replyUid = replyUid;
    }

    @Override
    public String toString() {
        return "WeChatReplyMsg{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", recMsgId='" + recMsgId + '\'' +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", hqMusicUrl='" + hqMusicUrl + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", replyUid='" + replyUid + '\'' +
                '}';
    }
}
