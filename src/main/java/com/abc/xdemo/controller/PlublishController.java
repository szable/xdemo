package com.abc.xdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlublishController {

    @RequestMapping("/publish")
    public String publish(){
        return "publish";
    }
}
