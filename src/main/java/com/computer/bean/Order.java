package com.computer.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * 订单的实体类
 * @author yangzexian
 * @date 2022/01/22
 */
public class Order implements Serializable {
    /**
     * 订单表的id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 购物车id组
     */
    private String carIds;
    /**
     * 订单号
     */
    private String out_trade_no;
    /**
     * 订单金额
     */
    private BigDecimal total_amount;
    /**
     * 订单类型
     */
    private String subject;
    /**
     * 订单备注
     */
    private String body;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 支付状态
     */
    private String payState;
    /**
     * 支付方式
     */
    private String payStyle;
    /**
     * 快递发送方式
     */
    private String sendStyle;
    /**
     * 是否发货 0未发货 1已发货 2已收货
     */
    private String sendStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除 0不删除  1删除
     */
    private Integer deleteStatus;

    /*超时时间参数*/
    private String timeout_express = "10m";
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getCarIds() {
        return carIds;
    }

    public void setCarIds(String carIds) {
        this.carIds = carIds;
    }

    public Order(Long id, Long userId, String carIds, String out_trade_no, BigDecimal total_amount, String subject, String body, String orderState, String payState, String payStyle, String sendStyle, String sendStatus, Date createTime, Date updateTime, Integer deleteStatus, String timeout_express, String product_code) {
        this.id = id;
        this.userId = userId;
        this.carIds = carIds;
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
        this.subject = subject;
        this.body = body;
        this.orderState = orderState;
        this.payState = payState;
        this.payStyle = payStyle;
        this.sendStyle = sendStyle;
        this.sendStatus = sendStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
        this.timeout_express = timeout_express;
        this.product_code = product_code;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", carIds='" + carIds + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", total_amount=" + total_amount +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", orderState='" + orderState + '\'' +
                ", payState='" + payState + '\'' +
                ", payStyle='" + payStyle + '\'' +
                ", sendStyle='" + sendStyle + '\'' +
                ", sendStatus=" + sendStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteStatus=" + deleteStatus +
                ", timeout_express='" + timeout_express + '\'' +
                ", product_code='" + product_code + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle;
    }

    public String getSendStyle() {
        return sendStyle;
    }

    public void setSendStyle(String sendStyle) {
        this.sendStyle = sendStyle;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public Order() {
    }
}
