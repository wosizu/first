package com.service.before;

import com.dao.admin.OrderDao;
import com.entity.Order;
import com.service.ServiceUtil;
import com.util.MyUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AddOrder {

    @Autowired
    OrderDao dao;

    public String addOrder(HttpServletRequest request){
        //对用户的订单状态进行判断
        try{
            Order order = new Order();
            order.setAmount(1);
            order.setGoods_id(Integer.valueOf(request.getParameter("goodsId")));
            order.setOrderdate(MyUtil.getTime());
            order.setStatus("审核中");
            order.setUser_id(Integer.valueOf(request.getParameter("userId")));
            dao.addOrder(order);
            System.out.printf("订单增加完成");
            return "/before/result";
        }catch(Exception e){
            e.printStackTrace();
            return ServiceUtil.PATH_ERROR;
        }

    }
}
