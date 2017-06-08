package com.imchen.utils;

import java.security.MessageDigest;

/**
 * Created by imchen on 2017/6/8.
 */
public class WeChatUtil {
    private static final String token="imchen";

    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr=new String[]{token,timestamp,nonce};
        sort(arr);
        StringBuffer content=new StringBuffer();
        for (int i=0;i<arr.length;i++){
            content.append(arr[i]);
        }

        MessageDigest md=null;
        String tempStr=null;

        try {
            md=MessageDigest.getInstance("SHA-1");
            byte[] digest=md.digest(content.toString().getBytes());
            tempStr=byteToStr(digest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tempStr != null ? tempStr.equals(signature.toUpperCase()) : false;
    }

    private static String byteToStr(byte[] byteArray){
        String strDigest="";
        for (int i=0;i<byteArray.length;i++){
            strDigest+=byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
                char[] tempArr = new char[2];
                 tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
                tempArr[1] = Digit[mByte & 0X0F];

                String s = new String(tempArr);
                 return s;
             }

    public static void sort(String[] a){
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[j].compareTo(a[i])<0){
                    String temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

}
