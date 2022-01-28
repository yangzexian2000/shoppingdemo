package com.computer.service.impl;

import com.alipay.api.AlipayApiException;
import com.computer.bean.Order;
import com.computer.bean.OrderLink;
import com.computer.config.AlipayUtil;
import com.computer.dao.OrderDao;
import com.computer.service.OrederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangzexian
 * @date 2022/01/22
 */
@Service
public class OrederServiceImpl implements OrederService {
    @Autowired
    OrderDao orderDao;
    @Override
    public String aliPay(Order alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }

    @Override
    public Integer saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public List<OrderLink> listUserOrder(Order order,String[] carIdArray) {
        return orderDao.listUserOrder(order,carIdArray);
    }

    @Override
    public Order getUserOrderByOid(Long id) {
        return orderDao.getUserOrderByOid(id);
    }

    @Override
    public List<Order> listUserOrderByUserId(Long userId) {
        return orderDao.listUserOrderByUserId(userId);
    }

    @Override
    public Integer updateOrderSendStatus(Long ordId, String sendStatus) {
        return orderDao.updateOrderSendStatus(ordId,sendStatus);
    }

    @Override
    public Integer deleteOrderByOrdId(Long ordId) {
        return orderDao.deleteOrderByOrdId(ordId);
    }

}
