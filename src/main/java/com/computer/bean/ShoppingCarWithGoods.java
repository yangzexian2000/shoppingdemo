package com.computer.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品购物车
 * @author yangzexian
 * @date 2022/01/18
 */
public class ShoppingCarWithGoods {
    /**
     * 购物车id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
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
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 逻辑删除
     */
    private Integer deleteStatus;

    /**
     * 商品的名字
     */
    private String goodsName;
    /**
     * 商品的价格
     */
    private BigDecimal goodsPrice;
    /**
     * 商品的图片
     */
    private String goodsPhoto;
    /**
     * 商品的库存信息
     */
    private Integer goodsAmount;
    /**
     * 商品的细节情况
     */
    private String goodsDetails;
    /**
     * 商品的类型
     */
    private String goodsType;
    /**
     * 商品的产地
     */
    private String goodsAddress;
    /**
     * 商品的销售数量
     */
    private Integer goodsSaleNum;

    public ShoppingCarWithGoods() {
    }

    public ShoppingCarWithGoods(Long id, Long userId, Long goodsId, Integer goodsNum, Date updateTime, Date createTime, Integer deleteStatus) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.deleteStatus = deleteStatus;
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

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public Integer getGoodsSaleNum() {
        return goodsSaleNum;
    }

    public void setGoodsSaleNum(Integer goodsSaleNum) {
        this.goodsSaleNum = goodsSaleNum;
    }

    public ShoppingCarWithGoods(Long id, Long userId, Long goodsId, Integer goodsNum, Date updateTime, Date createTime, Integer deleteStatus, String goodsName, BigDecimal goodsPrice, String goodsPhoto, Integer goodsAmount, String goodsDetails, String goodsType, String goodsAddress, Integer goodsSaleNum) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.deleteStatus = deleteStatus;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPhoto = goodsPhoto;
        this.goodsAmount = goodsAmount;
        this.goodsDetails = goodsDetails;
        this.goodsType = goodsType;
        this.goodsAddress = goodsAddress;
        this.goodsSaleNum = goodsSaleNum;
    }

    @Override
    public String toString() {
        return "ShoppingCarWithGoods{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", deleteStatus=" + deleteStatus +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsAddress='" + goodsAddress + '\'' +
                ", goodsSaleNum=" + goodsSaleNum +
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
