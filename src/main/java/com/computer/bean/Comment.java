package com.computer.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 * @author yangzexian
 * @date 2022/01/27
 */
public class Comment implements Serializable {
    private Long id;
    private Long userId;
    private Long goodsId;
    private String detail;
    private Date updateTime;
    private Date createTime;
    private Integer deleteStatus;
    private String satisfied;
    private String userName;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", detail='" + detail + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", deleteStatus=" + deleteStatus +
                ", satisfied='" + satisfied + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Comment(Long id, Long userId, Long goodsId, String detail, Date updateTime, Date createTime, Integer deleteStatus, String satisfied, String userName) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.detail = detail;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.deleteStatus = deleteStatus;
        this.satisfied = satisfied;
        this.userName = userName;
    }

    public Comment() {
    }

    public String getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(String satisfied) {
        this.satisfied = satisfied;
    }

    public Comment(Long id, Long userId, Long goodsId, String detail, Date updateTime, Date createTime, Integer deleteStatus, String satisfied) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.detail = detail;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.deleteStatus = deleteStatus;
        this.satisfied = satisfied;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
