package com.computer.constant;

/**
 * user的常量类
 * @author yangzexian
 * @date 2022/01/10
 */
public class Userconst {
    /**
     * data1 = 1 代表验证码为错误  交给ajax中的success函数进行处理
     */
    public static String data1 = "1";
    /**
     * data = 2 代表为成功
     */
    public static String data2 = "2";
    /**
     * data = 3  密码错误
     */
    public static String data3 = "3";
    /**
     * data = 4 账号不存在
     */
    public static String data4 = "4";
    /**
     * data = 5 邮箱已经组测
     */
    public static String data5 = "5";
    /**
     * alreadyEmail email已经存在
     */
    public static String alreadyEmail = "1";
    /**
     * alreadyPhone phone已经存在
     */
    public static String alreadyPhone = "2";
    /**
     * alreadyPhoneAndEmail phone and email 都存在
     */
    public static String alreadyPhoneAndEmail = "3";
    /**
     * agreeChange 两个都不存在可以修改
     */
    public static String agreeChange = "4";
    /**
     * 收藏成功
     */
    public static String saveCollect = "1";
    /**
     * 收藏失败 当没有登录的时候
     */
    public static String failCollect = "0";
    /**
     * 取消收藏
     */
    public static String deleteCollect = "2";

}
