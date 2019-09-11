package com.controller.before;

import com.dao.admin.GoodsDao;
import com.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsController1 {


    @RequestMapping("/before/goods")
    public String queryGoods(HttpServletRequest request){

        return "";
    }
}
