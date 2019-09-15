package com.controller.before;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseBeforeController {

    @RequestMapping("/before/login")
    public String toLogin(){
        return "/before/login";
    }

    @RequestMapping("/before")
    public String toMain(){
        return "/before/main";
    }
}
