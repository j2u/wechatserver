package com.imchen.utils;

import com.imchen.domain.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Vector;

/**
 * Created by imchen on 2017/6/7.
 */
public class HttpUtil {

    public static  final String defaultEnconde="UTF-8";

    public static HttpResponse sendGet(String requestUrl, String method, Map<String, String> parammeters, Map<String, String> properties) throws Exception {
        //对参数处理
        if ("GET".equalsIgnoreCase(method) && parammeters != null) {
            StringBuffer param = new StringBuffer();
            int i = 0;
            for (String key : parammeters.keySet()
                    ) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=").append(parammeters.get(key));
                i++;
            }
            requestUrl += param;
        }

        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method.toUpperCase());
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(true);

        if (properties != null) {
            for (String key : properties.keySet()
                    ) {
                connection.setRequestProperty(key, properties.get(key));
            }
        }

        if ("POST".equalsIgnoreCase(method) && parammeters != null) {
            StringBuffer param = new StringBuffer();
            for (String key : parammeters.keySet()
                    ) {
                param.append("&");
                param.append(key).append("=").append(parammeters.get(key));
            }

            connection.getOutputStream().write(param.toString().getBytes("UTF-8"));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();
        }
        return makeContent(requestUrl,connection);
    }

    private static HttpResponse makeContent(String requestUrl,HttpURLConnection connection) throws IOException {
        HttpResponse responser=new HttpResponse();
        InputStream inputStream=connection.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        Vector<String> vector=new Vector<String>();
        String line=null;
        StringBuffer buffer=new StringBuffer();
        while ((line=bufferedReader.readLine())!=null){
            buffer.append(line);
            vector.add(line);
        }
        bufferedReader.close();
        String ecoding;
        if(connection.getContentEncoding()==null){
            ecoding=defaultEnconde;
        }else{
            ecoding=connection.getContentEncoding();
        }
        responser.setEncode(ecoding);
        responser.setContentCollection(vector);
        responser.setContent(new String(buffer.toString().getBytes(ecoding)));
        responser.setConnectionTimeout(connection.getConnectTimeout());
        responser.setContentType(connection.getContentType());
        responser.setDefaultPost(connection.getURL().getDefaultPort());
        responser.setHost(connection.getURL().getHost());
        responser.setMethod(connection.getRequestMethod());
        responser.setPath(connection.getURL().getPath());
        responser.setFile(connection.getURL().getFile());
        responser.setProtocol(connection.getURL().getProtocol());
        responser.setQuery(connection.getURL().getQuery());
        responser.setRef(connection.getURL().getRef());
        responser.setReadTimeout(connection.getReadTimeout());
        responser.setResponseCode(connection.getResponseCode());
        responser.setResponseMessage(connection.getResponseMessage());
        responser.setUrlString(requestUrl);
        responser.setUserInfo(connection.getURL().getUserInfo());
        return responser;
    }

    public String sendPost(String requstUrl) {
        return null;
    }
}
