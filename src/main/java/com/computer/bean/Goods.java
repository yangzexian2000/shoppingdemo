package com.computer.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息表
 * @author yangzexian
 * @date 2022/01/12
 */
public class Goods  implements Serializable {
    /**
     * 商品的id
     */
    private Long id;
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
    /**
     * 商品的创建时间
     */
    private Date createTime;
    /**
     * 商品的创建时间
     */
    private Date updateTime;
    /**
     * 删除逻辑
     */
    private Integer deleteStatus;
    /**
     * 商品的收藏量
     */
    private Integer goodsCollect;

    public Goods(Long id, String goodsName, BigDecimal goodsPrice, String goodsPhoto, Integer goodsAmount, String goodsDetails, String goodsType, String goodsAddress, Integer goodsSaleNum, Date createTime, Date updateTime, Integer deleteStatus, Integer goodsCollect) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPhoto = goodsPhoto;
        this.goodsAmount = goodsAmount;
        this.goodsDetails = goodsDetails;
        this.goodsType = goodsType;
        this.goodsAddress = goodsAddress;
        this.goodsSaleNum = goodsSaleNum;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
        this.goodsCollect = goodsCollect;
    }

    public Goods() {
    }

    public Integer getGoodsCollect() {
        return goodsCollect;
    }

    public void setGoodsCollect(Integer goodsCollect) {
        this.goodsCollect = goodsCollect;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsAddress='" + goodsAddress + '\'' +
                ", goodsSaleNum=" + goodsSaleNum +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteStatus=" + deleteStatus +
                ", goodsCollect=" + goodsCollect +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
