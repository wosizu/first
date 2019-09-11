package com.service.before;

import com.dao.admin.GoodsDao;
import com.entity.Goods;
import com.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

@Service
public class QueryGoods {
    @Autowired
    GoodsDao dao;

    public String QueryGoods(HttpServletRequest request){
        try{
            Goods goods = dao.queryGoods(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("goods",goods);
            return ServiceUtil.PATH_GOODS;
        }catch(Exception e){
            return ServiceUtil.PATH_ERROR;
        }

    }
}
