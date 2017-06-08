package com.imchen.properties;

/**
 * Created by imchen on 2017/6/8.
 */
public class MeizuWeatherProperties {

    private String url;
    private String requestType;
    private String cityIds;
    private String params1;

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

    public String getCityIds() {
        return cityIds;
    }

    public void setCityIds(String cityIds) {
        this.cityIds = cityIds;
    }

    public String getParams1() {
        return params1;
    }

    public void setParams1(String params1) {
        this.params1 = params1;
    }

    @Override
    public String toString() {
        return "MeizuWeatherProperties{" +
                "url='" + url + '\'' +
                ", requestType='" + requestType + '\'' +
                ", cityIds='" + cityIds + '\'' +
                ", params1='" + params1 + '\'' +
                '}';
    }
}
