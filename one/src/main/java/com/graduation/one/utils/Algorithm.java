package com.graduation.one.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Descirption 一些常用的算法，加密
 * @Author JiWei
 * @Email lastcloud@yeah.net
 * @Date 2019/07/23 11:08
 */
public class Algorithm {

    /*** 功能描述:md5算法
     * @params:[source]
     * @return: java.lang.String
     * @Author: tongyw
     * @Date: 2019/12/13 13:27
     */
    public static String mD5(String source) {
        //加密对象
        MessageDigest md5;
        StringBuilder sb = new StringBuilder();
        try {
            // 指定加密方式
            md5 = MessageDigest.getInstance("md5");

            // 准备要加密的数据
            byte[] b = source.getBytes();
            // 加密
            byte[] digest = md5.digest(b);
            // 十六进制的字符
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
                    '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

            // 处理成十六进制的字符串(通常)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 返回加密后的字符串
        return sb.toString();
    }

}
