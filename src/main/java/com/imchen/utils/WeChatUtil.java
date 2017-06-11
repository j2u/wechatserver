package com.imchen.utils;

import com.imchen.domain.Article;
import com.imchen.domain.WeChatMessage;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by imchen on 2017/6/8.
 */
public class WeChatUtil {
    private static final String TOKEN = "imchen";
    private static final String START_DATA = "<![CDATA[";
    private static final String END_DATA = "]]>";

    private static final String TYPE_TEXT = "text";
    private static final String TYPE_IMAGE = "image";
    private static final String TYPE_VOICE = "voice";
    private static final String TYPE_VIDEO = "video";
    private static final String TYPE_MUSIC = "music";
    private static final String TYPE_NEWS = "news";
    private static Logger logger = LoggerFactory.getLogger(WeChatUtil.class);

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        sort(arr);
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }

        MessageDigest md = null;
        String tempStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tempStr = byteToStr(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempStr != null ? tempStr.equals(signature.toUpperCase()) : false;
    }

    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

    public static void sort(String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static WeChatMessage parseXml(String xmlStr) throws Exception {
//        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder=factory.newDocumentBuilder();
//        Document document=builder.parse(new String(xmlStr.getBytes("UTF-8")));
//        Element headNode=document.getDocumentElement();
//        NodeList nodeList=headNode.getChildNodes();
//        for (int i=0;i<nodeList.getLength();i++){
//            Node node=nodeList.item(i);
//            System.out.println("node:"+node.getNodeName()+" value:"+node.getNodeValue());
//        }
        WeChatMessage message;
        Document document = DocumentHelper.parseText(xmlStr);
        Element root = document.getRootElement();
        Iterator<?> iterator = root.elementIterator();

        Class<?> c = Class.forName("com.imchen.domain.WeChatMessage");
        message = (WeChatMessage) c.newInstance();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            Field field = c.getDeclaredField(element.getName());
            Method method = c.getDeclaredMethod("set" + element.getName(), field.getType());
            method.invoke(message, element.getText());
            System.out.println("getName:" + element.getName() + " value:" + element.getStringValue());
        }
        return message;
    }

    public static String makeTextModel(WeChatMessage message) {
        String currentModel = "";
        String commonModel = makeCommonText(message);
        switch (message.getMsgType()) {
            case TYPE_TEXT:
                currentModel = "<Content><![CDATA[" + message.getContent() + "]]></Content>\n" +
                        "</xml>\n";
                break;
            case TYPE_IMAGE:
                currentModel = "<Image>\n" +
                        "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                        "</Image>\n" +
                        "</xml>";
                break;
            case TYPE_VOICE:
                currentModel = "<Voice>\n" +
                        "<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>\n" +
                        "</Voice>\n" +
                        "</xml>";
                break;
            case TYPE_VIDEO:
                currentModel = "<Video>\n" +
                        "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                        "<Title><![CDATA[title]]></Title>\n" +
                        "<Description><![CDATA[description]]></Description>\n" +
                        "</Video> \n" +
                        "</xml>";
                break;
            case TYPE_MUSIC:
                currentModel = "<Music>\n" +
                        "<Title><![CDATA[TITLE]]></Title>\n" +
                        "<Description><![CDATA[DESCRIPTION]]></Description>\n" +
                        "<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>\n" +
                        "<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>\n" +
                        "<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>\n" +
                        "</Music>\n" +
                        "</xml>";
                break;
            case TYPE_NEWS:
                StringBuffer body = new StringBuffer();
                String head = "<ArticleCount>" + message.getArticleCount() + "</ArticleCount>\n" +
                        "<Articles>\n";
                for (Article article : message.getArticles()
                        ) {
                    String temp = "<item>\n" +
                            "<Title><![CDATA[" + article.getTitle() + "]]></Title> \n" +
                            "<Description><![CDATA[" + article.getDescription() + "]]></Description>\n" +
                            "<PicUrl><![CDATA[" + article.getPicUrl() + "]]></PicUrl>\n" +
                            "<Url><![CDATA[" + article.getUrl() + "]]></Url>\n" +
                            "</item>\n";
                    body.append(temp);
                }
                String tail = "</Articles>\n" +
                        "</xml>";
                currentModel = head + body + tail;
                break;
            default:
                currentModel = "<Content><![CDATA[" + message.getContent() + "]]></Content>\n" +
                        "</xml>\n";
                break;
        }

        return commonModel + currentModel;
    }

    /**
     * make a common model text for message start content
     *
     * @param message
     * @return commonText
     */
    private static String makeCommonText(WeChatMessage message) {
        String commonText = "<xml>\n" +
                "<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>\n" +
                "<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>\n" +
                "<CreateTime>" + message.getCreateTime() + "</CreateTime>\n " +
                "<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>\n";
        return commonText;
    }

    public static String millisToDate(long millis){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(millis);
    }
}
