package com.imchen.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by imchen on 2017/6/8.
 */
@ConfigurationProperties(prefix = "openApi.express100")
@Configuration
public class Express100Properties {
    private String url;
    private String requestType;
    private String params1;
    private String params2;
    private String jsonFormat;
    private String xmlFormat;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getParams1() {
        return params1;
    }

    public void setParams1(String params1) {
        this.params1 = params1;
    }

    public String getParams2() {
        return params2;
    }

    public void setParams2(String params2) {
        this.params2 = params2;
    }

    public String getJsonFormat() {
        return jsonFormat;
    }

    public void setJsonFormat(String jsonFormat) {
        this.jsonFormat = jsonFormat;
    }

    public String getXmlFormat() {
        return xmlFormat;
    }

    public void setXmlFormat(String xmlFormat) {
        this.xmlFormat = xmlFormat;
    }

    @Override
    public String toString() {
        return "Express100Properties{" +
                "url='" + url + '\'' +
                ", requestType='" + requestType + '\'' +
                ", params1='" + params1 + '\'' +
                ", params2='" + params2 + '\'' +
                ", jsonFormat='" + jsonFormat + '\'' +
                ", xmlFormat='" + xmlFormat + '\'' +
                '}';
    }
}
