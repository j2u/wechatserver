package com.imchen.domain;

import org.springframework.stereotype.Service;

import java.util.Vector;

/**
 * Created by imchen on 2017/6/7.
 */
public class HttpResponse {

    private Vector<String> contentCollection;
    private String urlString;
    private int defaultPost;
    private String file;
    private String host;
    private String path;
    private String protocol;
    private String query;
    private String ref;
    private String userInfo;
    private String content;
    private String encode;
    private int responseCode;
    private String responseMessage;
    private String contentType;
    private String method;
    private long connectionTimeout;
    private long readTimeout;

    public HttpResponse(){}

    public Vector<String> getContentCollection() {
        return contentCollection;
    }

    public void setContentCollection(Vector<String> contentCollection) {
        this.contentCollection = contentCollection;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public int getDefaultPost() {
        return defaultPost;
    }

    public void setDefaultPost(int defaultPost) {
        this.defaultPost = defaultPost;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "contentCollection=" + contentCollection +
                ", urlString='" + urlString + '\'' +
                ", defaultPost=" + defaultPost +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", protocol='" + protocol + '\'' +
                ", query='" + query + '\'' +
                ", ref='" + ref + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", content='" + content + '\'' +
                ", encode='" + encode + '\'' +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                ", contentType='" + contentType + '\'' +
                ", method='" + method + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", readTimeout=" + readTimeout +
                '}';
    }
}
