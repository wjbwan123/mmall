package com.mmall.utils;

/**
 * 用户状态
 * @author hanyi
 * @date 2017-03-23 20:59
 */
public enum UserStatus {
    /**
     * 禁用
     */
    DISABLE(0),
    /**
     * 正常
     */
    NORMAL(1);

    private int value;

    private UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
