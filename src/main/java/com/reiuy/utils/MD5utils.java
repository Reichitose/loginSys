package com.reiuy.utils;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5utils {
    /**
     *
     * 调用方法为
     * String text = MD5utils.getMd5(text,"UTF-8",false,32);
     * 为获取text的,小写结果的32位长度的md5加密结果
     *
     */



    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 获取MD5加密结果
     *
     * @param plainText   要加密的原字符串
     * @param charsetName 编码类型一般是:UTF-8
     * @param uppercase   是否转为大写字符串
     * @param bit         加密结果位数（16，32）,默认是32
     * @return 返回加密结果
     */
    public static String getMd5(String plainText, String charsetName, boolean uppercase, Integer bit) {
        byte[] btInput = plainText.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest;
        try {
            //获得MD5摘要对象
            messageDigest = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要信息
            messageDigest.update(btInput);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5签名过程中出现错误,算法异常");
        }
        byte[] digest = messageDigest.digest();
        //字节数组转成16进制字符串
        String result = byteArrayToHexString(digest);
        //如果获取的是16位加密结果的，则截取原加密结果（32位）中间的16位，也就是8-24位
        if (bit != null && bit == 16) {
            //截取下标从0开始
            result = result.substring(8, 24);
        }
        //结果的大小写处理
        return uppercase ? result.toUpperCase() : result;
    }

    /**
     * 字节数组转成16进制字符串
     *
     * @param bytes 要转换的字节数组
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(byteToHexString(b));
        }
        return builder.toString();
    }

    /**
     * 字节转成16进制字符
     *
     * @param b 要转换的字节
     * @return
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
