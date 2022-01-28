package com.computer.utils;


import java.net.URLEncoder;
import java.util.Random;

/**
 * 手机验证码
 * @author : yangzexian
 * @date : 2021/12/02
 */
public class SmsApiHttpSendTest {

    /**
     * 短信发送(验证码通知，会员营销)
     * 接口文档地址：http://www.danmi.com/developer.html#smsSend
     * (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
     */
    private static String num ="" ;


    /**
     * 生成随机的4为数验证码
     * @return
     */
    public static String getNum() {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);
            sb.append(str.charAt(number));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * 发送验证码
     * @param phone
     * @throws Exception
     */
    public static void  execute(String phone,String num2) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("accountSid").append("=").append(Config.ACCOUNT_SID);
        sb.append("&to").append("=").append(phone);
        //这里发生的是参数
        String num = num2;
        System.out.println("num:"+num+"phone:"+phone);
        sb.append("&param").append("=").append(URLEncoder.encode(num, "UTF-8"));
        //这里的templateid对应的是后台中信息发生模板的id
        sb.append("&templateid").append("=").append(275756);
//        sb.append("&smsContent").append("=").append( URLEncoder.encode(smsContent,"UTF-8"));
        String body = sb.toString() + HttpUtil.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
        String result = HttpUtil.post(Config.BASE_URL, body);
        System.out.println(result);
    }



    public static void main(String[] args) {
        SmsApiHttpSendTest am = new SmsApiHttpSendTest();
//        String phone="18859590078";
        try {
//            execute(phone);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}