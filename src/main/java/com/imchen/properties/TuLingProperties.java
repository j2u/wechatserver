package com.imchen.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Created by imchen on 2017/6/12.
 */
@ConfigurationProperties(prefix = "TuLing.api")
@Configuration
public class TuLingProperties {
    private String url;
    private String key;
    private String secret;
    private String param2;
    private String param1;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @Override
    public String toString() {
        return "TuLingProperties{" +
                "url='" + url + '\'' +
                ", key='" + key + '\'' +
                ", secret='" + secret + '\'' +
                ", param2='" + param2 + '\'' +
                ", param1='" + param1 + '\'' +
                '}';
    }
}
