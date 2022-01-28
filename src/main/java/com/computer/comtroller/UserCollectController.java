package com.computer.comtroller;

import com.computer.bean.Collect;
import com.computer.bean.Goods;
import com.computer.bean.ShoppingCarWithGoods;
import com.computer.bean.User;
import com.computer.constant.Userconst;
import com.computer.service.CollectService;
import com.computer.service.GoodsService;
import com.computer.service.ShoppingCarService;
import com.computer.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户收藏
 * @author yangzexian
 * @date 2022/01/15
 */
@Controller
@RequestMapping("/user")
public class UserCollectController {
    @Autowired
    CollectService collectService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    ShoppingCarService shoppingCarService;
    /**
     * 用户收藏和删除收藏 且更新商品的收藏数
     * @param collect
     * @return
     * @throws ParseException
     */
    @RequestMapping("saveCollect")
    @ResponseBody
    public String svaeCollect(Collect collect) throws ParseException {
        collect.setCreateTime(TimeUtils.getNewTime());
        collect.setUpdateTime(TimeUtils.getNewTime());
        if(null == collect.getUserId()){
            return Userconst.failCollect;
        }else {
            Collect collect1 = collectService.getCollect(collect);
            if (collect1 != null) {
                collectService.deleteCollect(collect);
                Goods goodsByGid = goodsService.getGoodsByGid(collect.getGoodId());
                goodsByGid.setUpdateTime(TimeUtils.getNewTime());
                goodsByGid.setGoodsCollect(goodsByGid.getGoodsCollect()-1);
                Integer integer1 = goodsService.updateGoodsCollect(goodsByGid);
                return Userconst.deleteCollect;
            }
            Integer integer = collectService.saveCollect(collect);
            Goods goodsByGid = goodsService.getGoodsByGid(collect.getGoodId());
            goodsByGid.setUpdateTime(TimeUtils.getNewTime());
            goodsByGid.setGoodsCollect(goodsByGid.getGoodsCollect()+1);
            Integer integer1 = goodsService.updateGoodsCollect(goodsByGid);
            return Userconst.saveCollect;
        }
    }

    /**
     * 用户个人收藏
     * @param request
     * @param pageNum
     * @return
     */
    @RequestMapping("/showCollect")
    public String showCollect(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        Collect collect = new Collect();
        User user = (User)request.getSession().getAttribute("user");
        collect.setUserId(user.getUserId());
        List<Collect> collects1 = collectService.ListUserCollects(collect);

        //进行分页
        PageHelper.startPage(pageNum,1);
        List<Collect> collects = collectService.ListUserCollects(collect);
        PageInfo<Collect> pageInfo = new PageInfo<Collect>(collects);
        ArrayList<Goods> goods = new ArrayList<>();
        for (int i = 0; i < collects.size(); i++) {
            Goods goodsByGid = goodsService.getGoodsByGid(collects.get(i).getGoodId());
            goods.add(goodsByGid);
        }
        request.setAttribute("collectSize",collects1.size());
        request.setAttribute("collects",goods);
        request.setAttribute("pageInfo",pageInfo);
        List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
        request.setAttribute("shoppingCars",shoppingCars);
        return "userCollect";
    }

    /**
     * 已经收藏的便签
     * @param userId
     * @return
     */
    @RequestMapping("/listCollects")
    @ResponseBody
    public ArrayList<Long> listCollects(@RequestParam("userId")Long userId){
        Collect collect = new Collect();
        collect.setUserId(userId);
        List<Collect> collects = collectService.ListUserCollects(collect);
        ArrayList<Long> integers = new ArrayList<Long>();
        for (int i = 0; i < collects.size(); i++) {
            Long goodId = collects.get(i).getGoodId();
            integers.add(goodId);
        }
        return integers;
    }
}
