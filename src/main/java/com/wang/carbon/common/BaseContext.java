package com.wang.carbon.common;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param phone
     */
    public static void setCurrentPhone(String phone){
        threadLocal.set(Long.valueOf(phone));
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentPhone(){
        return threadLocal.get();
    }
}