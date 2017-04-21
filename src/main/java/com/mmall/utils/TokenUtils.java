package com.mmall.utils;

import java.util.UUID;

/**
 * token工具类
 *
 * @author hanyi
 * @date 2017年04月21日
 */
public class TokenUtils {

    /**
     * 通过uuid获得一个唯一的token
     * @return token
     */
    public static String getToken() {
        return UUID.randomUUID().toString();
    }
}
