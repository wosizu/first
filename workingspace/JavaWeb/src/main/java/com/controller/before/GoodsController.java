package com.controller.before;

import com.dao.admin.GoodsDao;
import com.entity.Goods;
import com.service.before.QueryGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("beforeGoodsController")
public class GoodsController {

    @Autowired
    QueryGoods service;
    @RequestMapping("/before/goods")
    public String queryGoods(HttpServletRequest request){
        service.QueryGoods(request);
        return "before/goods";
    }
}
