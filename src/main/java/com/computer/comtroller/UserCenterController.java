package com.computer.comtroller;

import com.computer.bean.User;
import com.computer.constant.Userconst;
import com.computer.service.UserService;
import com.computer.utils.MD5utils;
import com.computer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户中心
 * @author yangzexian
 * @date 2022/01/11
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    @Autowired
    UserService userService;
    /**
     * 前往用户信息页
     * @return
     */
    @RequestMapping("/userMsg")
    public String userMsg(){
        return "userMessage";
    }

    /**
     * 用户修改信息的时候判断修改后的值是否在数据库中存在
     * @param user
     * @return
     * @throws ParseException
     */
    @RequestMapping("/checkMsg")
    @ResponseBody
    public String checkMsg(User user) throws ParseException {
        if( null== user.getUserEmail() && null == user.getUserPhone()){
            return Userconst.agreeChange;
        }
        if( null!= user.getUserPhone() && null != user.getUserEmail()){
            List<User> user1 = userService.listUsers(user);
            if(user1.size() != 0){
                return Userconst.alreadyPhoneAndEmail;
            }
        }else if( null != user.getUserPhone()){
            List<User> user1 = userService.listUsers(user);
            if(user1.size() != 0){
                return Userconst.alreadyPhone;
            }
        }else if( null != user.getUserEmail()){
            List<User> user1 = userService.listUsers(user);
            if(user1.size() != 0){
                return Userconst.alreadyEmail;
            }
        }
        return Userconst.agreeChange;
    }

    /**
     * 更换用户信息
     * @param user
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/updetaUserEmaliOrPhone")
    public String updetaUserEmaliOrPhone(User user, HttpServletRequest request) throws ParseException {
        user.setUpdateTime(TimeUtils.getNewTime());
        Integer integer = userService.updetaUserEmaliOrPhone(user);
        List<User> user1 = userService.listUsers(user);
        request.getSession().setAttribute("user",user1.get(0));
        return "redirect:/user/userMsg";
    }

    /**
     * 修改 头像
     * @param file
     * @param userId
     * @return
     */
    @RequestMapping("/changePhoto")
    public String changePhoto(@RequestParam("file")MultipartFile file, @RequestParam("userId")Long userId, HttpServletRequest request) throws IOException, ParseException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:static/images/");
        String path = resource.getURL().toString().replace("/target/classes", "/src/main/resources").replace("file:/","");
        if(!file.isEmpty()){
            //文件上传过来的名字
            String originalFilename = file.getOriginalFilename();
            //获取当前系统时间
            String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String newFile = str+originalFilename ;
            file.transferTo(new File(path,newFile));
            User user = new User();
            user.setUserId(userId);
            user.setUserPhoto(newFile);
            user.setUpdateTime(TimeUtils.getNewTime());
            Integer integer = userService.updateUserPhoto(user);
            request.getSession().setAttribute("user",userService.getUserByUserId(user));
        }
        return "redirect:/user/userMsg";
    }

    /**
     * 前往修改密码页
     * @return
     */
    @RequestMapping("/changePwdPage")
    public String changePwdPage(){
        return "userChangePassword";
    }

    /**
     * 更新密码
     * @param user
     * @param request
     * @param newPwd
     * @return
     */
    @RequestMapping("/changePwd")
    @ResponseBody
    public String changePwd(User user, HttpServletRequest request, @RequestParam("newPwd")String newPwd) throws ParseException {
        User userByUserId = userService.getUserByUserId(user);
        if(userByUserId.getUserPwd().equals(MD5utils.getMD5Code(user.getUserPwd()))){
            user.setUserPwd(newPwd);
            user.setUpdateTime(TimeUtils.getNewTime());
            user.setUserPhone(userByUserId.getUserPhone());
            Integer integer = userService.updetaUserPwd(user);
            request.getSession().removeAttribute("user");
            return Userconst.data2;
        }else{
            //前端传递过来的旧密码为错误
            return Userconst.data3;
        }
    }
}
