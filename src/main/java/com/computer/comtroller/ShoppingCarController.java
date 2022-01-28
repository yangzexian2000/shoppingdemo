package com.computer.comtroller;

import com.computer.bean.*;
import com.computer.constant.Goodconst;
import com.computer.service.GoodsService;
import com.computer.service.ShoppingCarService;
import com.computer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

/**
 * 购物车的controller
 * @author yangzexian
 * @date 2022/01/18
 */
@RequestMapping("/goods")
@Controller
public class ShoppingCarController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    ShoppingCarService shoppingCarService;
    /**
     * 前往购物车页
     * @param request
     * @return
     */
    @RequestMapping("/gotoShoppingCar")
    public String gotoShoppingCar(HttpServletRequest request){
        //推荐商品
        List<Goods> goods = goodsService.listGoodses();
        request.setAttribute("goodsList",goods);
        //购物车显示
        User user =(User)request.getSession().getAttribute("user");
        if(user != null){
            List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
            request.setAttribute("shoppingCars",shoppingCars);
        }
        return "shopCar";
    }
    /**
     * 将用户id 和商品 id添加进购物车中
     * @param shoppingCar
     * @return
     */
    @RequestMapping("/addShoppingCar")
    @ResponseBody
    public String addShoppingCar(ShoppingCar shoppingCar) throws ParseException {
        shoppingCar.setCreateTime(TimeUtils.getNewTime());
        shoppingCar.setUpdateTime(TimeUtils.getNewTime());
        //先判断是否添加过商品  添加过的话就进行数量的更新
        ShoppingCar shoppingCarByUserIdAndGoodsId = shoppingCarService.getShoppingCarByUserIdAndGoodsId(shoppingCar);
        if (shoppingCarByUserIdAndGoodsId != null) {
            shoppingCarByUserIdAndGoodsId.setGoodsNum(shoppingCarByUserIdAndGoodsId.getGoodsNum()+shoppingCar.getGoodsNum());
            shoppingCarService.updateGoodsNum(shoppingCarByUserIdAndGoodsId);
        }else {
            //没添加过的话就进行添加
            Integer integer = shoppingCarService.saveShoppingCar(shoppingCar);
        }
        return Goodconst.successAddShoppingCar;
    }

    /**
     * 计算价钱
     * @return
     */
    @RequestMapping("/countMoney")
    @ResponseBody
    public Map<String,String> countMoney(ChangeMoneyUtil changeMoneyUtil){
        HashMap<String, String> money = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#0.00");
        Double goodsPrice = changeMoneyUtil.getNum() * changeMoneyUtil.getPrice() ;
        money.put("goodsPrice",df.format(goodsPrice));
        Integer integer = shoppingCarService.updateShoppingCarBuyNum(changeMoneyUtil.getNum(),changeMoneyUtil.getId());
        if(changeMoneyUtil.getOldMoney()<goodsPrice){
            money.put("countMoney",df.format(changeMoneyUtil.getCountMoney()+changeMoneyUtil.getPrice()));
        }else {
            money.put("countMoney",df.format(changeMoneyUtil.getCountMoney()-changeMoneyUtil.getPrice()));
        }
//        Collection<String> values = money.values();
//        values.forEach(System.out::println);
        return  money;
    }

    /**
     * 在前端页面删除 ajax删除数据并不刷新页面
     * @param id
     * @return
     */
    @RequestMapping("/deleteShoppingCar")
    @ResponseBody
    public BigDecimal deleteShoppingCar(@RequestParam("id")Long[] id, BigDecimal countMoney){
        if(id.length == 1){
            ShoppingCarWithGoods goodsLinkGoodsWithShoppingCarBycarId = shoppingCarService.getGoodsLinkGoodsWithShoppingCarBycarId(id[0]);
            //单价*数量
            BigDecimal reduceMoney = goodsLinkGoodsWithShoppingCarBycarId.getGoodsPrice().multiply( new BigDecimal(goodsLinkGoodsWithShoppingCarBycarId.getGoodsNum()));
            countMoney = countMoney.subtract(reduceMoney);
            System.out.println(countMoney);
            Integer integer = shoppingCarService.deleteShoppingCarByCarId(id[0]);
            return countMoney;
        }else {
            for (int i = 0; i < id.length; i++) {
                ShoppingCarWithGoods goodsLinkGoodsWithShoppingCarBycarId = shoppingCarService.getGoodsLinkGoodsWithShoppingCarBycarId(id[i]);
                //单价*数量
                if (goodsLinkGoodsWithShoppingCarBycarId != null) {
                    BigDecimal reduceMoney = goodsLinkGoodsWithShoppingCarBycarId.getGoodsPrice().multiply( new BigDecimal(goodsLinkGoodsWithShoppingCarBycarId.getGoodsNum()));
                    countMoney = countMoney.subtract(reduceMoney);
                    System.out.println(countMoney);
                    Integer integer = shoppingCarService.deleteShoppingCarByCarId(id[i]);
                }
            }
            return countMoney;
        }
    }
    /**
     * 前往支付页面
     * @param id
     * @return
     */
    @RequestMapping("/gotoPayFor")
    @ResponseBody
    public String gotoPayFor(@RequestParam("id")Long[] id,HttpServletRequest request){
        ArrayList<Long> carIds = new ArrayList<>();
        ArrayList<ShoppingCarWithGoods> shoppingCarWithGoods = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            ShoppingCarWithGoods goodsLinkGoodsWithShoppingCarBycarId = shoppingCarService.getGoodsLinkGoodsWithShoppingCarBycarId(id[i]);
            //单价*数量
            if (goodsLinkGoodsWithShoppingCarBycarId != null) {
                carIds.add(id[i]);
                shoppingCarWithGoods.add(goodsLinkGoodsWithShoppingCarBycarId);
            }
        }
        System.out.println(carIds);
        request.getSession().setAttribute("shoppingCars",shoppingCarWithGoods);
        return "";
    }

    @RequestMapping("/changeMoney")
    @ResponseBody
    public BigDecimal countMoney(@RequestParam("id")Long[] id){
        BigDecimal countMoney = new BigDecimal(0);
        for (int i = 0; i < id.length; i++) {
            ShoppingCarWithGoods goodsLinkGoodsWithShoppingCarBycarId = shoppingCarService.getGoodsLinkGoodsWithShoppingCarBycarId(id[i]);
            BigDecimal reduceMoney = goodsLinkGoodsWithShoppingCarBycarId.getGoodsPrice().multiply( new BigDecimal(goodsLinkGoodsWithShoppingCarBycarId.getGoodsNum()));
            countMoney = countMoney.add(reduceMoney);
        }
        return countMoney;
    }


}
