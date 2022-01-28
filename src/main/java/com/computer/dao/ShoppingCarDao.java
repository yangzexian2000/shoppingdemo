package com.computer.dao;

import com.computer.bean.ShoppingCar;
import com.computer.bean.ShoppingCarWithGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车的dao层
 * @author yangzexian
 * @date 2022/01/18
 */
@Mapper
public interface ShoppingCarDao {
    /**
     *  将用户和对应的商品添加到购物车中
     * @param shoppingCar
     * @return
     */
    Integer saveShoppingCar(ShoppingCar shoppingCar);
    /**
     * 根据用户id查询其相对于的购物车中的所有信息
     * @param userId
     * @return
     */
    List<ShoppingCar> listShoppingCarsByUserId(Long userId);
    /**
     * 根据用户id和商品id 查询是否被添加过
     * @param shoppingCar
     * @return
     */
    ShoppingCar getShoppingCarByUserIdAndGoodsId(ShoppingCar shoppingCar);
    /**
     * 更改商品数量信息
     * @param shoppingCar
     * @return
     */
    Integer updateGoodsNum(ShoppingCar shoppingCar);
    /**
     * 购物车中的数据链表查询
     * @param userId
     * @return
     */
    List<ShoppingCarWithGoods> listGoodsLinkGoodsWithShoppingCar(Long userId);

    /**
     * 更新购物车中的购买数量
     * @param id
     * @return
     */
    Integer updateShoppingCarBuyNum(Integer goodsNum,Long id);

    /**
     * 删除购物车  根据购物车id
     * @param carId
     * @return
     */
    Integer deleteShoppingCarByCarId(Long carId);

    /**
     * 根据购物车的id链表查找商品
     * @param id
     * @return
     */
    ShoppingCarWithGoods getGoodsLinkGoodsWithShoppingCarBycarId(Long id);
    /**
     * 根据购物车id查找购物车信息
     * @param carId
     * @return
     */
    ShoppingCar getShoppingCarByCarId(Long carId);
}
