package com.computer.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员的controller层
 * @author : yangzexian
 * @date : 2022/01/09
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
