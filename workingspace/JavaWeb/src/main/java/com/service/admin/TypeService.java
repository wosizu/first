package com.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.admin.GoodsTypeDao;
import com.entity.GoodsType;
import com.exception.LossInfoException;
import com.service.ServiceUtil;
import com.util.MyUtil;

@Service
public class TypeService {
	

		@Autowired
		GoodsTypeDao dao;
		
		GoodsType type;
		
		HttpServletRequest request;
		
		//通过这个方法来调用其他几个增删改查的方法，这样可以减少Contorller类的代码，把判断方法的逻辑也放在这里
		public String baseMethod(HttpServletRequest request) throws Exception {
			this.request = request;
			//通过这个方法来进行非空判断，然后直接调用打包goods的方法
			this.ensureNotEmpty(request);
			//通过反射来调用方法，这样来减少if else
			String jsp = (String)this.getClass().getMethod(request.getParameter("method")+"Type", GoodsType.class).invoke(this, this.type);
			return jsp;
		}
		
		public String addType(GoodsType type) {
			try {
				if(type.getTypename() == null) {
					throw new LossInfoException();
				}
				int changed = dao.addType(type);
				this.request.setAttribute("changed", changed);
				System.out.println("方法执行完毕");
				return ServiceUtil.PATH_RESULT;
			}catch(Exception e) {
				return ServiceUtil.PATH_ERROR;
			}
		}
		
		public String deleteType(GoodsType type) {
			try{
				if(type.getId() == 0) {
					throw new LossInfoException();
				}
				int changed = dao.deleteType(type.getId());
				this.request.setAttribute("changed", changed);
				System.out.println("方法执行完毕");
				return ServiceUtil.PATH_RESULT;
			}catch(Exception e) {
				return ServiceUtil.PATH_ERROR;
			}
		}
	////	
		public String updateType(GoodsType type) {
			try {
				if(type.getId() == 0) {
					throw new LossInfoException();
				}
				int changed = dao.updateType(type);
				this.request.setAttribute("changed", changed);
				System.out.println("执行完毕");
				return ServiceUtil.PATH_RESULT; 
			}catch(Exception e) {
				return ServiceUtil.PATH_ERROR;
			}
		}
	////	
		public String queryType(GoodsType type) {
			try{
				if(type.getId() == 0) {
					throw new LossInfoException();
				}
				type = dao.queryType(type.getId());
				this.request.setAttribute("type", type);
				System.out.println("方法执行完毕");
				return ServiceUtil.PATH_RESULT;
			}catch(Exception e) {
				return ServiceUtil.PATH_ERROR;
			}
		}
	//	
		//下面是工具方法
		public void packingType(int id,String typename) {
			
			GoodsType type = new GoodsType();
			type.setId(id);
			type.setTypename(typename);
			this.type = type;
		}
		
		public void ensureNotEmpty(HttpServletRequest request) throws Exception {
			//先获取所有的参数
			int id = 0;
			String typename=null;
			if(!request.getParameter("id").equals("")) {
				id = Integer.valueOf(request.getParameter("id"));
			}
			if(!request.getParameter("typename").equals("")) {
				typename = MyUtil.changeCoded(request.getParameter("typename"));
			}
			
			System.out.println("id:"+id);
			System.out.println("typename:"+typename);
			packingType(id,typename);
		}
		
		
}
