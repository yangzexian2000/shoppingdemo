package com.computer.comtroller;

import com.computer.bean.*;
import com.computer.service.BrowsingHistoryService;
import com.computer.service.GoodsService;
import com.computer.service.ShoppingCarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 前往浏览记录页
 * @author yangzexian
 * @date 2022/01/28
 */
@Controller
@RequestMapping("/user")
public class BrowsingHistoryController {
    @Autowired
    BrowsingHistoryService browsingHistoryService;
    @Autowired
    ShoppingCarService shoppingCarService;
    @Autowired
    GoodsService goodsService;

    /**
     * 前往浏览记录页面
     * @param request
     * @return
     */
    @RequestMapping("/gotoBrowsingHistory")
    public String gotoBrowsingHistory(HttpServletRequest request,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        User user = (User)request.getSession().getAttribute("user");
        List<History> histories1 = browsingHistoryService.listBrowsingHistoryByUserId(user.getUserId());
        //进行分页
        PageHelper.startPage(pageNum,8);
        List<History> histories = browsingHistoryService.listBrowsingHistoryByUserId(user.getUserId());
        PageInfo<History> pageInfo = new PageInfo<History>(histories);
        ArrayList<Goods> goods1 = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get(i).getGoodId());
            goods1.add(goodsByGid1);
        }
        request.setAttribute("histories",goods1);
        List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
        request.setAttribute("shoppingCars",shoppingCars);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("collectSize",histories1.size());
        return "userBrowsingHistory";
    }

    /**
     * 删除浏览记录
     * @param history
     * @return
     */
    @RequestMapping("/deleteBrowsingHistory")
    @ResponseBody
    public String deleteBrowsingHistory(History history){
        List<History> histories = browsingHistoryService.listBrowsingHistoryId(history);
        for (int i = 0; i < histories.size(); i++) {
            Integer integer = browsingHistoryService.deleteBrowsingHistory(histories.get(i));
        }
        return "2";
    }
}
