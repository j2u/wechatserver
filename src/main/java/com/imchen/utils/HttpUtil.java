package com.imchen.utils;

import com.imchen.domain.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
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

    public static final String DEFAULT_ENCODING = "UTF-8";
    public static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 通用http請求方法
     *
     * @param requestUrl 請求url
     * @param method     請求方式
     * @param parameters 請求參數Map<String, String>
     * @param properties 請求屬性
     * @return HttpResponse
     * @throws Exception
     */
    public static HttpResponse send(String requestUrl, String method, Map<String, String> parameters, Map<String, String> properties) throws Exception {
        //对参数处理
        if ("GET".equalsIgnoreCase(method) && parameters != null) {
            StringBuffer param = new StringBuffer();
            int i = 0;
            for (String key : parameters.keySet()
                    ) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=").append(parameters.get(key));
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

        if ("POST".equalsIgnoreCase(method) && parameters != null) {
            StringBuffer param = new StringBuffer();
            for (String key : parameters.keySet()
                    ) {
                param.append("&");
                param.append(key).append("=").append(parameters.get(key));
            }

            connection.getOutputStream().write(param.toString().getBytes(DEFAULT_ENCODING));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();
        }
        return makeContent(requestUrl, connection);
    }

    /**
     * 生成 HttpResponse 對象
     *
     * @param requestUrl 請求url
     * @param connection HttpURLConnetion
     * @return HttpResponse
     * @throws IOException
     */
    private static HttpResponse makeContent(String requestUrl, HttpURLConnection connection) throws IOException {
        HttpResponse responser = new HttpResponse();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_ENCODING));
        Vector<String> vector = new Vector<String>();
        String line = null;
        StringBuffer buffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            buffer.append(line);
//            logger.info("read line from buffer:{}", line);
            vector.add(line);
        }
        bufferedReader.close();
        String encoding;
        if (connection.getContentEncoding() == null) {
            encoding = DEFAULT_ENCODING;
        } else {
            encoding = connection.getContentEncoding();
        }
        String content = new String(buffer.toString().getBytes(encoding));
        responser.setEncode(encoding);
        responser.setContentCollection(vector);
        responser.setContent(content);
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
        logger.info("response charset:{} response content:{}", encoding, content);
        return responser;
    }

    /**
     * 解析http 請求
     *
     * @param request HttpServletRequest
     * @return String
     * @throws IOException
     */
    public static String saxRequest(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_ENCODING));
        String line = "";
        StringBuffer buffer = new StringBuffer();
        logger.info("開始解析消息");
        while ((line = bufferedReader.readLine()) != null) {
            logger.info(line);
            buffer.append(line);
        }
        logger.info("解析完成");
        return buffer.toString();
    }

//    public String sendPost(String requstUrl) {
//        return null;
//    }
}
