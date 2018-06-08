package com.eastrise.xunwu.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create by gzq on 2018/6/8 18:33
 */
@Controller
public class UserController {

    @GetMapping("/user/login")
    public String userLoginPage(){
        return "user/login";
    }
    @GetMapping("/user/center")
    public String userCenterPage(){
        return "user/center";
    }
}
