package com.computer.bean;

import java.util.Date;

/**
 * 商品购物车
 * @author yangzexian
 * @date 2022/01/18
 */
public class ShoppingCar {
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

    public ShoppingCar() {
    }

    public ShoppingCar(Long id, Long userId, Long goodsId, Integer goodsNum, Date updateTime, Date createTime, Integer deleteStatus) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", deleteStatus=" + deleteStatus +
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
