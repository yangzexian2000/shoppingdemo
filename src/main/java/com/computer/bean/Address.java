package com.computer.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 地址信息的实体类
 * @author yangzexian
 * @date  2021/12/22
 */
public class Address implements Serializable {
    /**
     * 地址表的id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 地址信息
     */
    private String address;
    /**
     * 地址详情
     */
    private String addressDetail;
    /**
     * 收件人信息
     */
    private String acceptName;
    /**
     * 电话
     */
    private String acceptPhone;
    /**
     * 固定电话
     */
    private String fixPhone;
    /**
     * 邮政编码
     */
    private String code;

    /**
     * 表的创建时间
     */
    private Date createTime;
    /**
     * 表的更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除
     */
    private int deleteStatus;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", acceptName='" + acceptName + '\'' +
                ", acceptPhone='" + acceptPhone + '\'' +
                ", fixPhone='" + fixPhone + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteStatus=" + deleteStatus +
                '}';
    }

    public Address() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public String getAcceptPhone() {
        return acceptPhone;
    }

    public void setAcceptPhone(String acceptPhone) {
        this.acceptPhone = acceptPhone;
    }

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Address(Long id, Long userId, String address, String addressDetail, String acceptName, String acceptPhone, String fixPhone, String code, Date createTime, Date updateTime, int deleteStatus) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.addressDetail = addressDetail;
        this.acceptName = acceptName;
        this.acceptPhone = acceptPhone;
        this.fixPhone = fixPhone;
        this.code = code;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
    }
}
