package com.md5;



import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 13:57
 * @Email:641819417@qq.com
 */
public class MD5Encrypt {

    public static String md5(String temp,String salt){
        byte[] secretBytes = null;
        try {
            MessageDigest  md = MessageDigest.getInstance("MD5");
            //对字符串加密
            md.update((temp + salt).getBytes("utf-8"));
            //获得加密后的byte数组
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static String md5(String temp){
        return md5(temp,"default");
    }
}
