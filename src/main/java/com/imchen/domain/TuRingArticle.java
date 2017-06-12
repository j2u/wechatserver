package com.imchen.domain;

/**
 * Created by imchen on 2017/6/12.
 */
public class TuRingArticle {

    private String article;
    private String source;
    private String icon;
    private String info;
    private String detailUrl;
    private String author;
    private String name;
    private String song;
    private String singer;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "TuRingArticle{" +
                "article='" + article + '\'' +
                ", source='" + source + '\'' +
                ", icon='" + icon + '\'' +
                ", info='" + info + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", song='" + song + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
