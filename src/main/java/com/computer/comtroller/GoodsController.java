package com.computer.comtroller;

import com.computer.bean.*;
import com.computer.constant.Goodconst;
import com.computer.constant.Userconst;
import com.computer.service.*;
import com.computer.utils.TimeUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 商品的controller层  处理商品首页和商品详情页
 * @author yangzexian
 * @date 2022/01/12
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CollectService collectService;
    @Autowired
    BrowsingHistoryService browsingHistoryService;
    @Autowired
    ShoppingCarService shoppingCarService;
    @Autowired
    OrederService orederService;
    @Autowired
    CommentService commentService;
    /**
     * 前往商品浏览页面
     * @return
     */
    @RequestMapping("/home")
    public String home (HttpServletRequest request){
        List<Goods> goods = goodsService.listGoodses();
        request.setAttribute("goodsList",goods);
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
            request.setAttribute("shoppingCars",shoppingCars);
        }
        return "goodsHome";
    }

    /**
     * 查询商品详情
     * @param goodId
     * @param request
     * @return
     */
    @RequestMapping("/showDetails")
    public String showDetails(@RequestParam("goodId")Long goodId, HttpServletRequest request) throws ParseException {
        Goods goodsByGid = goodsService.getGoodsByGid(goodId);
        request.setAttribute("good", goodsByGid);
        List<Goods> goods = goodsService.listGoodses();
        Random random = new Random(30);
        List<Goods> goods2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Goods goods1 = goods.get((int) (Math.random() * goods.size()));
            goods2.add(goods1);
        }
        User user = (User) request.getSession().getAttribute("user");
        //用户登录的话 商品详情页显示自己的浏览信息
        if (user != null) {
            History history = new History(user.getUserId(), goodId);
            history.setCreateTime(TimeUtils.getNewTime());
            history.setUpdateTime(TimeUtils.getNewTime());
            Integer integer = browsingHistoryService.saveBrowsingHistory(history);
            List<History> histories = browsingHistoryService.listBrowsingHistoryByUserId(user.getUserId());
            ArrayList<Goods> goods1 = new ArrayList<>();
            for (int i = 0; i < histories.size(); i++) {
                Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
                goods1.add(goodsByGid1);
            }
            request.setAttribute("histories",goods1);
        }else {
            //用户没登录就显示数据库中随机的用户的访问信息
            List<History> histories = browsingHistoryService.listBrowsingHistory();
            ArrayList<Goods> goods1 = new ArrayList<>();
            for (int i = 0; i < histories.size(); i++) {
                Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
                goods1.add(goodsByGid1);
            }
            request.setAttribute("histories",goods1);
        }
        request.setAttribute("goodsList",goods2);
        if(user!=null){
            Collect collect = new Collect();
            collect.setUserId(new Long("6"));
            collect.setGoodId(goodId);
            Collect collect1 = collectService.getCollect(collect);
            if(null != collect1){
                request.setAttribute("collect",collect1);
            }
            List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
            request.setAttribute("shoppingCars",shoppingCars);
        }
        List<Comment> comments = commentService.listCommentByGoodsId(goodId);
        int goodNum = 0;
        int badNum = 0;
        int num = 0;
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getSatisfied().equals("0")) {
                num++;
            }else if(comments.get(i).getSatisfied().equals("1")){
                goodNum++;
            }else if(comments.get(i).getSatisfied().equals("-1")){
                badNum++;
            }
        }
        request.setAttribute("comments",comments);
        request.setAttribute("goodNum",goodNum);
        request.setAttribute("badNum",badNum);
        request.setAttribute("num",num);
        request.setAttribute("success",(goodNum == 0 ) ? 0:goodNum/comments.size());
        request.setAttribute("common",(num == 0 ) ? 0:num*1.0/comments.size());
        request.setAttribute("fail",(badNum == 0 ) ? 0:badNum*1.0/comments.size());
        return "goodsDetials";
    }

    /**
     * 是否可以发表评论
     * @param comment
     * @param request
     * @return
     */
    @RequestMapping("/saveComment")
    @ResponseBody
    public String saveComment(Comment comment,HttpServletRequest request) throws ParseException {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            //表示没登录
            return Userconst.failCollect;
        }
        comment.setUserId(user.getUserId());
        comment.setCreateTime(TimeUtils.getNewTime());
        comment.setUpdateTime(TimeUtils.getNewTime());
        List<Order> orders = orederService.listUserOrderByUserId(user.getUserId());
        if (orders == null || orders.size() == 0) {
            return Goodconst.neverBuyGoods;
        }
        for (int i = 0; i < orders.size(); i++) {
            String carIds = orders.get(i).getCarIds();
            String[] split = carIds.split(",");
            for (int i1 = 0; i1 < split.length; i1++) {
                ShoppingCar shoppingCarByCarId = shoppingCarService.getShoppingCarByCarId(new Long(split[i1]));
                if (comment.getGoodsId().equals(shoppingCarByCarId.getGoodsId())) {
                    commentService.saveComment(comment);
                    return Goodconst.buyGoods;
                }
            }
        }
        return Goodconst.neverBuyGoods;
    }
}
