package com.computer.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** user的实体类
 * @author : yangzexian
 * @date : 2022/01/10
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     *用户密码
     */
    private String userPwd;
    /**
     * 用户手机
     */
    private String userPhone;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户头像
     */
    private String userPhoto;
    /**
     * 用户余额
     */
    private BigDecimal userMoney;
    /**
     * 用户预警余额
     */
    private BigDecimal userWarning;
    /**
     * 用户的创建时间
     */
    private Date createTime;
    /**
     * 用户的更新实际
     */
    private Date updateTime;
    /**
     * 逻辑删除 0不删 1删除
     */
    private Integer deleteStatus;

    /**
     *用户会员类型 0普通 1钻石 2超级
     */
    private String userType;

    /**
     * 用户性别  0 男 1女
     */
    private Integer userSex;

    private Integer userPoints;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userMoney=" + userMoney +
                ", userWarning=" + userWarning +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteStatus=" + deleteStatus +
                ", userType='" + userType + '\'' +
                ", userSex=" + userSex +
                ", userPoints=" + userPoints +
                '}';
    }

    public Integer getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(Integer userPoints) {
        this.userPoints = userPoints;
    }

    public User(Long userId, String userName, String userPwd, String userPhone, String userEmail, String userPhoto, BigDecimal userMoney, BigDecimal userWarning, Date createTime, Date updateTime, Integer deleteStatus, String userType, Integer userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPhoto = userPhoto;
        this.userMoney = userMoney;
        this.userWarning = userWarning;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
        this.userType = userType;
        this.userSex = userSex;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getUserWarning() {
        return userWarning;
    }

    public void setUserWarning(BigDecimal userWarning) {
        this.userWarning = userWarning;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}

