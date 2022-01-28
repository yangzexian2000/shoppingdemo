package com.computer.utils;

/**
 * 支付宝网关配置
 */
public class Config {
	/**
	 * url前半部分
	 */
	public static final String BASE_URL = "https://openapi.danmi.com/distributor/sendSMS";

	/**
	 * 开发者注册后系统自动生成的账号，可在官网登录后查看
	 */
	public static final String ACCOUNT_SID = "eb908723707308ae9bd0888c3ec488a7";

	/**
	 * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看
	 */
	public static final String AUTH_TOKEN = "351a9846461fc3aa2063d0014aaebcd1";

	/**
	 * 响应数据类型, JSON或XML
	 */
	public static final String RESP_DATA_TYPE = "JSON";
}