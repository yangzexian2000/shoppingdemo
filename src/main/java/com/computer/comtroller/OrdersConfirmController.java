package com.computer.comtroller;

import com.alipay.api.AlipayApiException;
import com.computer.bean.*;
import com.computer.constant.Goodconst;
import com.computer.service.AddressService;
import com.computer.service.OrederService;
import com.computer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 订单确认controller
 * @author yangzexian
 * @date 2022/01/21
 */
@Controller
@RequestMapping("/goods")
public class OrdersConfirmController {
    @Autowired
    AddressService addressService;
    @Autowired
    OrederService orederService;
    /**
     * 前往订单确认页
     * @return
     */
    @RequestMapping("/parForPage")
    public String payForPage(HttpServletRequest request){
        User user =(User)request.getSession().getAttribute("user");
        List<Address> addresses = addressService.listAddressWithUserId(new Long("6"));
        request.setAttribute("addresses",addresses);
        ArrayList<ShoppingCarWithGoods> shoppingCars = (ArrayList<ShoppingCarWithGoods>) request.getSession().getAttribute("shoppingCars");
        request.setAttribute("shoppingCars",shoppingCars);
        return "ordersConfirm";
    }

    /**
     * 沙箱支付生成订单
     * @param order
     * @param request
     * @return
     * @throws AlipayApiException
     * @throws ParseException
     */
    @RequestMapping("/saveOrder")
    @ResponseBody
    public String alipay(Order order, HttpServletRequest request) throws AlipayApiException, ParseException {
        ArrayList<ShoppingCarWithGoods> shoppingCars = (ArrayList<ShoppingCarWithGoods>) request.getSession().getAttribute("shoppingCars");
        String carId = "" ;
        for (int i = 0; i < shoppingCars.size(); i++) {
            if( i == shoppingCars.size()-1){
                carId += shoppingCars.get(i).getId();
            }else{
                carId += shoppingCars.get(i).getId()+",";
            }
        }
        order.setCarIds(carId);
        order.setCreateTime(TimeUtils.getNewTime());
        order.setUpdateTime(TimeUtils.getNewTime());
        Integer integer = orederService.saveOrder(order);
        request.getSession().setAttribute("orderId",order.getId());
        return orederService.aliPay(order);
    }

    /**
     * 前往支付页面
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/successPay")
    public String successPay(HttpServletRequest request) throws ParseException {
        User user = (User) request.getSession().getAttribute("user");
        Long orderId = (Long) request.getSession().getAttribute("orderId");
        if (orderId != null) {
            Order order = new Order();
            order.setPayState("0");
            order.setOrderState("1");
            order.setUpdateTime(TimeUtils.getNewTime());
            order.setId(orderId);
            Integer integer = orederService.updateOrder(order);
        }
        List<Order> orders = orederService.listUserOrderByUserId(user.getUserId());
        HashMap<String, List<OrderLink>> stringListHashMap = new HashMap<>();
        int successNum = 0;
        int spendNum = 0;
        int failNum = 0;
        for (int i = 0; i < orders.size(); i++) {
            Date createTime = orders.get(i).getCreateTime();
            //设置好SimpleDateFormat的格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取当前时间，此时时间的格式为String
            String source = df.format(createTime);
            Order order2 =  orders.get(i);
            if(order2.getSendStatus().equals("0")){
                failNum++;
            }else if(order2.getSendStatus().equals("1")){
                spendNum++;
            }else if(order2.getSendStatus().equals("2")){
                successNum++;
            }
            String carIds = order2.getCarIds();
            String[] carIdArray = carIds.split(",");
            List<OrderLink> orderLinks = orederService.listUserOrder(orders.get(i),carIdArray);
            stringListHashMap.put("下单时间："+ source + "| 订单号："+orders.get(i).getOut_trade_no(),orderLinks);
        }
        request.setAttribute("orders",stringListHashMap);
        request.setAttribute("successNum",successNum);
        request.setAttribute("spendNum",spendNum);
        request.setAttribute("failNum",failNum);
        return "userOrderform";
    }

    /**
     * 确认收货
     * @param ordId
     */
    @RequestMapping("/accpetGoods")
    @ResponseBody
    public String accpetGoods(@RequestParam("ordId")Long ordId){
        Order userOrderByOid = orederService.getUserOrderByOid(ordId);
        if (Goodconst.goodsSpendSendState.equals(userOrderByOid.getSendStatus())) {
            Integer integer = orederService.updateOrderSendStatus(ordId, "2");
            return Goodconst.goodsSpendSuccess;
        }else {
            return Goodconst.goodsSpendFail;
        }

    }
    /**
     * 删除订单
     * @param ordId
     */
    @RequestMapping("/deleteOrd")
    @ResponseBody
    public void deleteOrd(@RequestParam("ordId")Long ordId){
        Integer integer = orederService.deleteOrderByOrdId(ordId);
    }
}
