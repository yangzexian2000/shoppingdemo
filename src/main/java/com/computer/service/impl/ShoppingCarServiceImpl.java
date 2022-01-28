package com.computer.service.impl;

import com.computer.bean.ShoppingCar;
import com.computer.bean.ShoppingCarWithGoods;
import com.computer.dao.ShoppingCarDao;
import com.computer.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车的实现层
 * @author yangzexian
 * @date 2022/01/19
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingCarDao shoppingCarDao;

    @Override
    public Integer saveShoppingCar(ShoppingCar shoppingCar) {
        return shoppingCarDao.saveShoppingCar(shoppingCar);
    }
    @Override
    public List<ShoppingCar> listShoppingCarsByUserId(Long userId) {
        return shoppingCarDao.listShoppingCarsByUserId(userId);
    }
    @Override
    public ShoppingCar getShoppingCarByUserIdAndGoodsId(ShoppingCar shoppingCar) {
        return shoppingCarDao.getShoppingCarByUserIdAndGoodsId(shoppingCar);
    }
    @Override
    public Integer updateGoodsNum(ShoppingCar shoppingCar) {
        return shoppingCarDao.updateGoodsNum(shoppingCar);
    }

    @Override
    public List<ShoppingCarWithGoods> listGoodsLinkGoodsWithShoppingCar(Long userId) {
        return shoppingCarDao.listGoodsLinkGoodsWithShoppingCar(userId);
    }

    @Override
    public Integer updateShoppingCarBuyNum(Integer num,Long id) {
        return shoppingCarDao.updateShoppingCarBuyNum(num,id);
    }

    @Override
    public Integer deleteShoppingCarByCarId(Long carId) {
        return shoppingCarDao.deleteShoppingCarByCarId(carId);
    }

    @Override
    public ShoppingCarWithGoods getGoodsLinkGoodsWithShoppingCarBycarId(Long id) {
        return shoppingCarDao.getGoodsLinkGoodsWithShoppingCarBycarId(id);
    }

    @Override
    public ShoppingCar getShoppingCarByCarId(Long carId) {
        return shoppingCarDao.getShoppingCarByCarId(carId);
    }
}
