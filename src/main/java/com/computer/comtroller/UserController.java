package com.computer.comtroller;

import com.computer.bean.*;
import com.computer.constant.Userconst;
import com.computer.service.*;
import com.computer.utils.CaptchaUtils;
import com.computer.utils.MD5utils;
import com.computer.utils.SmsApiHttpSendTest;
import com.computer.utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户controller层
 * @author : yangzexian
 * @date : 2022/01/09
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CollectService collectService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    BrowsingHistoryService browsingHistoryService;
    @Autowired
    ShoppingCarService shoppingCarService;
    //定义一个全局的接收短信验证码
    public static String phonecode = "0000";


    /**
     * 前往注册页面
     * @return
     */
    @RequestMapping("/registered")
    public String register(){
        return "registered";
    }

    /**
     * 前往登录页
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 忘记密码页
     * @return
     */
    @RequestMapping("/forgetPwd")
    public String forgetPwd(){
        return "forgetPwd";
    }

    /**
     * 前往用户中心页
     * @return
     */
    @RequestMapping("/userInfo")
    public String userInfo(HttpServletRequest request){
        Collect collect = new Collect();
        User user = (User)request.getSession().getAttribute("user");
        collect.setUserId(user.getUserId());
        List<Collect> collects = collectService.ListUserCollects(collect);
        ArrayList<Goods> goods = new ArrayList<>();
        for (int i = 0; i < collects.size(); i++) {
            Goods goodsByGid = goodsService.getGoodsByGid(collects.get(i).getGoodId());
            goods.add(goodsByGid);
        }
        request.setAttribute("collects",goods);
        List<History> histories = browsingHistoryService.listBrowsingHistoryByUserId(user.getUserId());
        ArrayList<Goods> goods1 = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++) {
            Goods goodsByGid1 = goodsService.getGoodsByGid(histories.get((int) (Math.random() * histories.size())).getGoodId());
            goods1.add(goodsByGid1);
        }
        request.setAttribute("histories",goods1);
        List<ShoppingCarWithGoods> shoppingCars = shoppingCarService.listGoodsLinkGoodsWithShoppingCar(user.getUserId());
        request.setAttribute("shoppingCars",shoppingCars);
        return "userInfo";
    }

    /**
     * 获取手机验证码
     * @param user
     * @return
     */
    @RequestMapping("/getcode")
    @ResponseBody
    public String getcode(User user,
                          @RequestParam(value = "reg",required = false)String reg){
        String data = "2";
        //判断是注册状态还是登录状态
        List<User> userByPhone = userService.listUsers(user);
        log.info("userByPhone:"+userByPhone);
        if(reg == null){
            //登录时候发的短信
            if (userByPhone.size() != 0){
                SmsApiHttpSendTest am = new SmsApiHttpSendTest();
                //将生成的手机验证码保存在全局当中
                phonecode = SmsApiHttpSendTest.getNum();
                try {
//                    SmsApiHttpSendTest.execute(user.getUserPhone(),phonecode);
                    log.info("生成的phonecode"+phonecode);
                } catch (Exception e) {
                    log.error("发送手机验证码出现异常：[{}]", e.getMessage(), e);
                }
                return  Userconst.data2;
            }else {
                data = "1";
                return  Userconst.data1;
            }
        }else{
            //查看电话号码是否存在在数据库中
            //没有就给注册
            if (userByPhone.size() == 0) {
                SmsApiHttpSendTest am = new SmsApiHttpSendTest();
                //将生成的手机验证码保存在全局当中
                phonecode = SmsApiHttpSendTest.getNum();
                try {
//                    SmsApiHttpSendTest.execute(user.getUserPhone(),phonecode);
                    log.info("生成的phonecode"+phonecode);
                } catch (Exception e) {
                    log.error("发送手机验证码出现异常：[{}]", e.getMessage(), e);
                }
                return  Userconst.data2;
            }else{
                data = "1";
                return  Userconst.data1;
            }
        }
    }


    /**
     * 添加用户
     * @param user 用户信息
     * @param code 验证码
     * @return
     */
    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(User user,@RequestParam("code")String code) throws ParseException {
        user.setCreateTime(TimeUtils.getNewTime());
        user.setUpdateTime(TimeUtils.getNewTime());
        User user1 = new User();
        user1.setUserEmail(user.getUserEmail());
        List<User> user2 = userService.listUsers(user1);
        if(user2.size()!=0){
            return Userconst.data5;
        }
        if(phonecode.equals(code)){
            Integer integer = userService.saveUser(user);
            return  Userconst.data2;
        }else{
            //验证码错误
            return  Userconst.data1;
        }
    }

    /**
     * 生成图形验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtils c = new CaptchaUtils();
        String code = c.getCode();
        //放入session当中  在进行登录的时候进行判断
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        c.write(response.getOutputStream());
    }

    /**
     * 登录验证
     * @param user
     * @param request
     * @param code
     * @return
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(User user, HttpServletRequest request, @RequestParam("code")String code){
        List<User> user1 = userService.listUsers(user);
        if(user1.size()!=0){
            User user2 = user1.get(0);
            String code1 = (String) request.getSession().getAttribute("code");
            if(code1.equalsIgnoreCase(code)){
                if(user2.getUserPwd().equals(MD5utils.getMD5Code(user.getUserPwd()))){
                    request.getSession().setAttribute("user",user2);
                    return Userconst.data2;
                }else{
                    return Userconst.data3;
                }
            }else{
                return Userconst.data1;
            }
        }else{
            //=0  账户不存在
            return Userconst.data4;
        }
    }

    /**
     * 更新用户密码
     * @param user
     * @param code
     * @return
     */
    @RequestMapping("/forgetPassword")
    @ResponseBody
    public String forgetPwd(User user, @RequestParam("code")String code) throws ParseException {
        user.setUpdateTime(TimeUtils.getNewTime());
        if(phonecode.equals(code)){
            Integer integer = userService.updetaUserPwd(user);
            return Userconst.data2;
        }else{
            return Userconst.data1;
        }
    }

}
