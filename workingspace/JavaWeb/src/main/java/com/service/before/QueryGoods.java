package com.service.before;

import com.dao.admin.GoodsDao;
import com.dao.admin.UserDao;
import com.entity.Goods;
import com.entity.User;
import com.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class QueryGoods {
    @Autowired
    GoodsDao dao;
    @Autowired
    UserDao dao1;

    public String QueryGoods(HttpServletRequest request){
        try{
            //Goods goods = dao.queryGoods(Integer.valueOf(request.getParameter("id")));
            Goods goods = dao.queryGoods(Integer.valueOf(request.getParameter("goodsId")));
            //把用户与商品信息保存到requestyu域当中
            request.setAttribute("goods",goods);
            int userId = 0;
            Cookie[] cookie = request.getCookies();
            for (Cookie c:cookie){
                if(c.getName().equals("userId")){
                    userId = Integer.valueOf(c.getValue());
                }
            }

            User user = dao1.queryUser(userId);
            request.setAttribute("user",user);
            return ServiceUtil.PATH_GOODS;
        }catch(Exception e){
            return ServiceUtil.PATH_ERROR;
        }

    }
}
