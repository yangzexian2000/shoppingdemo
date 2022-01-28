package com.computer.comtroller;

import com.computer.bean.Collect;
import com.computer.bean.Goods;
import com.computer.bean.History;
import com.computer.bean.User;
import com.computer.constant.Goodconst;
import com.computer.service.BrowsingHistoryService;
import com.computer.service.GoodsService;
import com.computer.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品搜索页
 * @author yangzexian
 * @date 2022/01/16
 */
@Controller
@RequestMapping("/goods")
public class GoodsListController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    BrowsingHistoryService browsingHistoryService;

    /**
     * 根据名称进行商品的模糊查询
     * @param serch
     * @return
     */
    @RequestMapping("/serchGoods")
    public String serchGoods(@RequestParam("serch")String serch, HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1")int pageNum) throws ParseException {
        //推荐商品
        List<Goods> goods = goodsService.listGoodses();
        request.setAttribute("goodsList",goods);
        User user = (User) request.getSession().getAttribute("user");

        //显示数据库中随机的用户的访问信息
        List<History> histories = browsingHistoryService.listBrowsingHistory();
        ArrayList<Goods> goods1 = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
            goods1.add(goodsByGid1);
        }
        request.setAttribute("histories",goods1);
        //商品销量情况
        Goods goods2 = new Goods();
        List<Goods> goodsSale = goodsService.listGoodsOrderBySaleNum(goods2);
        request.setAttribute("goodsSale",goodsSale);
        //模糊查询数据
        //进行分页
        PageHelper.startPage(pageNum,16);
        List<Goods> goods3 = goodsService.listGoodsByLimit(serch);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
        request.setAttribute("pageInfo",pageInfo);
        //模糊查询的数据进行前端页面回显
        request.setAttribute("serch",serch);
        request.getSession().setAttribute("serch",serch);
        request.setAttribute("mohu","2");
        return "productList";
    }

    /**
     * 对查询到的商品进行排序
     * @param serch
     * @param limit
     * @param request
     * @return
     */
    @RequestMapping("/sort")
    public String sortGoods(@RequestParam("serch")String serch, @RequestParam(value = "limit",required = false)String limit, @RequestParam(value = "pageNum",defaultValue = "1")int pageNum, HttpServletRequest request){
        List<Goods> goods4 = goodsService.listGoodsByLimit(serch);
        if (pageNum == 0){
            pageNum =1;
        }else if(pageNum>=( Math.ceil(goods4.size()/16.0) )){
            pageNum = (int) Math.ceil(goods4.size()/16.0);
            System.out.println(pageNum);
        }
        if( Goodconst.undefined.equals(limit) ){
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsByLimit((String) request.getSession().getAttribute("serch"));
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","all");
        }else if(Goodconst.saleNum.equals(limit)){
            Goods goods = new Goods();
            goods.setGoodsName((String) request.getSession().getAttribute("serch"));
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsOrderBySaleNum(goods);
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","saleNum");
        }else if(Goodconst.price.equals(limit)){
            Goods goods = new Goods();
            goods.setGoodsName((String) request.getSession().getAttribute("serch"));
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsOrderByPrice(goods);
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","price");
        }
        request.setAttribute("limit",limit);
        request.setAttribute("mohu","1");
        //推荐商品
        List<Goods> goods = goodsService.listGoodses();
        request.setAttribute("goodsList",goods);
        User user = (User) request.getSession().getAttribute("user");
        //显示数据库中随机的用户的访问信息
        List<History> histories = browsingHistoryService.listBrowsingHistory();
        ArrayList<Goods> goods1 = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
            goods1.add(goodsByGid1);
        }
        request.setAttribute("histories",goods1);
        //商品销量情况
        Goods goods2 = new Goods();
        List<Goods> goodsSale = goodsService.listGoodsOrderBySaleNum(goods2);
        request.setAttribute("goodsSale",goodsSale);
        return "productList";
    }

    /**
     * 已经进行了一次模糊查询过后，根据悬浮栏上的价格区间进行查找商品
     * @param begin
     * @param end
     * @param selectId
     * @param priceId
     * @param request
     * @param pageNum
     * @return
     */
    @RequestMapping("/listGoodsSaleMoney")
    public String listGoodsSaleMoney(@RequestParam("begin")BigDecimal begin,
                                     @RequestParam("end")BigDecimal end,
                                     @RequestParam("selectId")String selectId,
                                     @RequestParam("priceId")String priceId,
                                     HttpServletRequest request,
                                     @RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        //推荐商品
        List<Goods> goods = goodsService.listGoodses();
        request.setAttribute("goodsList",goods);
        User user = (User) request.getSession().getAttribute("user");
        //显示数据库中随机的用户的访问信息
        List<History> histories = browsingHistoryService.listBrowsingHistory();
        ArrayList<Goods> goods1 = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
            goods1.add(goodsByGid1);
        }
        request.setAttribute("histories",goods1);
        //商品销量情况
        Goods goods2 = new Goods();
        List<Goods> goodsSale = goodsService.listGoodsOrderBySaleNum(goods2);
        request.setAttribute("goodsSale",goodsSale);
        //开始进行价格排序
        String  serch = (String) request.getSession().getAttribute("serch");
        if( Goodconst.all.equals(selectId) ){
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsSaleMoneyByAll(begin,end,serch);
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","all");
        }else if(Goodconst.saleNum.equals(selectId)){
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsSaleMoneyByPriceOrSaleNum(begin,end,serch,"saleNum");
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","saleNum");
        }else if(Goodconst.price.equals(selectId)){
            PageHelper.startPage(pageNum,16);
            List<Goods> goods3 = goodsService.listGoodsSaleMoneyByPriceOrSaleNum(begin,end,serch,"price");
            PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods3);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("selectId","price");
        }
        request.setAttribute("priceId",priceId);
        return "productList";
    }
}
