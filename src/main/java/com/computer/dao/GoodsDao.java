package com.computer.dao;

import com.computer.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * goods商品的dao层
 * @author yangzexian
 * @date 2022/01/12
 */
@Mapper
public interface GoodsDao {
    /**
     * 查询所有的商品
     * @return
     */
    List<Goods> listGoodses();

    /**
     * 查询商品根据id
     * @param goodId
     * @return
     */
    Goods getGoodsByGid(Long goodId);
    /**
     * 增加商品的收藏次数
     * @param goods
     * @return
     */
    Integer updateGoodsCollect(Goods goods);
    /**
     * 查询商品的销量 从高到低
     * @return
     */
    List<Goods> listGoodsOrderBySaleNum(Goods goods);

    /**
     * 查询商品的价格 从高到低
     * @return
     */
    List<Goods> listGoodsOrderByPrice(Goods goods);
    /**
     * 模糊查询 根据商品名称
     * @return
     */
    List<Goods> listGoodsByLimit(String goodsName);
    /**
     * 商品的价格区间
     * @param begin
     * @param end
     * @param goodsName
     * @return
     */
    List<Goods> listGoodsSaleMoneyByAll(BigDecimal begin,BigDecimal end,String goodsName);

    /**
     * 商品的价格区间 之前已经进行了模糊查询了一次
     * @param begin
     * @param end
     * @param goodsName
     * @param limit
     * @return
     */
    List<Goods> listGoodsSaleMoneyByPriceOrSaleNum(BigDecimal begin,BigDecimal end,String goodsName,String limit);
}
