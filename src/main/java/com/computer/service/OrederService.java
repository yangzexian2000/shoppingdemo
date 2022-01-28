package com.computer.service;

import com.alipay.api.AlipayApiException;
import com.computer.bean.Order;
import com.computer.bean.OrderLink;

import java.util.List;

/**
 * 生成订单的接口
 * @author yangzexian
 * @date 2022/01/22
 */
public interface OrederService {
    /**
     *支付信息
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(Order alipayBean) throws AlipayApiException;

    /**
     * 添加订单信息
     * @param order
     * @return
     */
    Integer saveOrder(Order order);
    /**
     * 根据订单id 更新订单状态
     * @param order
     * @return
     */
    Integer updateOrder(Order order);
    /**
     * 更具用户id 查找所有的用户订单数据
     * @param
     * @return
     */
    List<OrderLink> listUserOrder(Order order,String[] carIdArray);
    /**
     * 根据订单id 查找到订单信息
     * @param id
     * @return
     */
    Order getUserOrderByOid(Long id);

    /**
     * 根据用户id 查找用户所有的订单编号 和 创建时间
     * @param
     * @return
     */
    List<Order> listUserOrderByUserId(Long userId);

    /**
     * 确认收获
     * @param ordId
     * @param sendStatus
     * @return
     */
    Integer updateOrderSendStatus(Long ordId,String sendStatus);
    /**
     * 根据订单id删除订单
     * @param ordId
     * @return
     */
    Integer deleteOrderByOrdId(Long ordId);
}
