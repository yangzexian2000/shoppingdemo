package com.computer.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单的连表查询
 * @author yangzexian
 * @date 2022/01/24
 */
public class OrderLink implements Serializable {
    /**
     * 订单表的id
     */
    private Long id;

    public OrderLink(Long id, Long goodsId, Integer goodsNum, Date createTime, String out_trade_no, BigDecimal total_amount, Integer sendStatus, String goodsName, BigDecimal goodsPrice, String goodsDetails) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.createTime = createTime;
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
        this.sendStatus = sendStatus;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDetails = goodsDetails;
    }

    @Override
    public String toString() {
        return "OrderLink{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                ", createTime=" + createTime +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", total_amount=" + total_amount +
                ", sendStatus=" + sendStatus +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDetails='" + goodsDetails + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 更新时间
     */
    private Date createTime;
    /**
     * 订单号
     */
    private String out_trade_no;
    /**
     * 订单金额
     */
    private BigDecimal total_amount;
    /**
     * 是否发货 0未发货 1已发货
     */
    private Integer sendStatus;
    /**
     * 商品的名字
     */
    private String goodsName;
    /**
     * 商品的价格
     */
    private BigDecimal goodsPrice;
    /**
     * 商品的细节情况
     */
    private String goodsDetails;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public OrderLink() {
    }

    public OrderLink(Long goodsId, Integer goodsNum, Date createTime, String out_trade_no, BigDecimal total_amount, Integer sendStatus, String goodsName, BigDecimal goodsPrice, String goodsDetails) {
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.createTime = createTime;
        this.out_trade_no = out_trade_no;
        this.total_amount = total_amount;
        this.sendStatus = sendStatus;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDetails = goodsDetails;
    }
}
