package com.computer.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏信息的实体类
 * @author yangzexian
 * @date 2022/01/14
 */
public class Collect implements Serializable {
    /**
     * 浏览记录的id
     */
    private Long id;
    /**
     * 用户的id
     */
    private Long userId;
    /**
     * 商品的id
     */
    private Long goodId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除
     */
    private Integer deleteStatus;

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodId=" + goodId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteStatus=" + deleteStatus +
                '}';
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

    public Collect(Long id, Long userId, Long goodId, Date createTime, Date updateTime, Integer deleteStatus) {
        this.id = id;
        this.userId = userId;
        this.goodId = goodId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
    }



    public Collect() {
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

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }
}
