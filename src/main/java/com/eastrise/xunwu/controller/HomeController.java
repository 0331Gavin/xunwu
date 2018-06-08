package com.eastrise.xunwu.controller;

import com.eastrise.xunwu.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by gzq on 2018/6/1 15:44
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name","11123fff");
        return "index";
    }
    @GetMapping("/404")
    public String notFoundPage(){
        return "404";
    }
    @GetMapping("/403")
    public String accessError(){
        return "403";
    }
    @GetMapping("/500")
    public String internalError(){
        return "500";
    }
    @GetMapping("/logout")
    public String logoutPage(){
        return "logout";
    }
}
