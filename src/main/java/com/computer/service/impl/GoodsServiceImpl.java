package com.computer.service.impl;

import com.computer.bean.Goods;
import com.computer.dao.GoodsDao;
import com.computer.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品的impl实现层
 * @author yangzexian
 * @date 2022/01/12
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    public List<Goods> listGoodses() {
        return goodsDao.listGoodses();
    }

    @Override
    public Goods getGoodsByGid(Long goodId) {
        return goodsDao.getGoodsByGid(goodId);
    }

    @Override
    public Integer updateGoodsCollect(Goods goods) {
        return goodsDao.updateGoodsCollect(goods);
    }

    @Override
    public List<Goods> listGoodsOrderBySaleNum(Goods goods) {
        return goodsDao.listGoodsOrderBySaleNum(goods);
    }

    @Override
    public List<Goods> listGoodsOrderByPrice(Goods goods) {
        return goodsDao.listGoodsOrderByPrice(goods);
    }
    @Override
    public List<Goods> listGoodsByLimit(String goodsName) {
        return goodsDao.listGoodsByLimit(goodsName);
    }
    @Override
    public List<Goods> listGoodsSaleMoneyByAll(BigDecimal begin, BigDecimal end, String goodsName) {
        return goodsDao.listGoodsSaleMoneyByAll(begin,end,goodsName);
    }

    @Override
    public List<Goods> listGoodsSaleMoneyByPriceOrSaleNum(BigDecimal begin, BigDecimal end, String goodsName, String limit) {
        return goodsDao.listGoodsSaleMoneyByPriceOrSaleNum(begin,end,goodsName,limit);
    }
}
