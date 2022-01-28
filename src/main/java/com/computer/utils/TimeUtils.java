package com.computer.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于时间的工具类
 * @author : yangzexian
 * @date : 2021/12/14
 */
@Slf4j
public class TimeUtils {

    /**
     * 获取当前系统的操作时间
     * @return
     * @throws ParseException
     */
    public static Date getNewTime() throws ParseException {
        //先建立一个Date对象
        Date date=new Date();
        //设置好SimpleDateFormat的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间，此时时间的格式为String
        String source = df.format(date);
        //将String类型转换成Date形式
        Date updateTime = df.parse(source);
        return updateTime;
    }

    /**
     * 开始时间转换
     *
     * @param startTime
     * @return
     */
    public String startTime(String startTime) {
        String times = null;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date time = df.parse(startTime + " 00:00:00");
                times = df.format(time);
            } catch (ParseException e) {
                log.error("生成时间出现异常：[{}]", e.getMessage(), e);
            }

        return times;
    }

    /**
     * 结束时间转换
     *
     * @param endTime
     * @return
     */
    public String endTime(String endTime) {
        String times = null;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date time = df.parse(endTime + " 23:59:59");
                times =  df.format(time);
            } catch (ParseException e) {
                log.error("时间转换异常：[{}]", e.getMessage(), e);
            }

        return times;
    }
}
