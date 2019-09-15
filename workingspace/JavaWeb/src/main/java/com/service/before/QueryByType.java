package com.service.before;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.before.QueryByTypeDao;
import com.entity.Goods;
import com.service.ServiceUtil;

@Service
public class QueryByType {

	@Autowired
	QueryByTypeDao dao;

	public String query(HttpServletRequest request) {

		//保存当前是第几页
		HttpSession session = request.getSession();
		int nonius = 0;
		List<Goods> goodsList;
		int typeId = Integer.valueOf(request.getParameter("typeid"));
		if(session.getValue("nonius") != null) {
			nonius = (Integer)session.getValue("nonius");
			goodsList = dao.query(typeId,nonius);
			session.setAttribute("nonius", nonius=nonius+11);
		}else {
			goodsList = dao.query(typeId,nonius);
			session.setAttribute("nonius", nonius=nonius+11);
		}

		if(goodsList.size() > 0) {
			request.setAttribute("goodsList", goodsList);

			return ServiceUtil.PATH_SERACH;
		}else {
			System.out.println("这里来了");
			session.setAttribute("nonius",0);
			return ServiceUtil.PATH_ERROR;
		}

	}

}
