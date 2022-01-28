package com.computer.bean;

/**
 * 处理购物车计算价钱而传过来参数的实体类
 * @author yangzexian
 * @date 2022/01/20
 */
public class ChangeMoneyUtil {
    /**
     * 购物车id
     */
    private Long id;
    /**
     * 单个商品的数量
     */
    private Integer num;
    /**
     * 单价
     */
    private Double price;
    /**
     * 购物车总价
     */
    private Double  countMoney;
    /**
     * 之前单个商品的总价= 数量*单价
     */
    private Double  oldMoney;
    /**
     * 用户id
     */
    private Long userId;

    @Override
    public String toString() {
        return "ChangeMoneyUtil{" +
                "id=" + id +
                ", num=" + num +
                ", price=" + price +
                ", countMoney=" + countMoney +
                ", oldMoney=" + oldMoney +
                ", userId=" + userId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ChangeMoneyUtil(Long id, Integer num, Double price, Double countMoney, Double oldMoney, Long userId) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.countMoney = countMoney;
        this.oldMoney = oldMoney;
        this.userId = userId;
    }

    public ChangeMoneyUtil() {
    }

    public ChangeMoneyUtil(Long id, Integer num, Double price, Double countMoney, Double oldMoney) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.countMoney = countMoney;
        this.oldMoney = oldMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(Double countMoney) {
        this.countMoney = countMoney;
    }

    public Double getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(Double oldMoney) {
        this.oldMoney = oldMoney;
    }
}
