package com.controller.before;

import com.service.before.AddOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("beforeOrderController")
public class OrderController {

    @Autowired
    AddOrder service;

    @RequestMapping("/before/order")
    public String addOrder(HttpServletRequest request){
        System.out.println("我只是来了");
        String jsp = service.addOrder(request);
        System.out.println(jsp);
        return jsp;
    }
}
