package com.eastrise.xunwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
