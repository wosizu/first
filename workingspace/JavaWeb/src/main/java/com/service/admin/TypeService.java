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
		
		//ͨ�������������������������ɾ�Ĳ�ķ������������Լ���Contorller��Ĵ��룬���жϷ������߼�Ҳ��������
		public String baseMethod(HttpServletRequest request) throws Exception {
			this.request = request;
			//ͨ��������������зǿ��жϣ�Ȼ��ֱ�ӵ��ô��goods�ķ���
			this.ensureNotEmpty(request);
			//ͨ�����������÷���������������if else
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
				System.out.println("����ִ�����");
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
				System.out.println("����ִ�����");
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
				System.out.println("ִ�����");
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
				System.out.println("����ִ�����");
				return ServiceUtil.PATH_RESULT;
			}catch(Exception e) {
				return ServiceUtil.PATH_ERROR;
			}
		}
	//	
		//�����ǹ��߷���
		public void packingType(int id,String typename) {
			
			GoodsType type = new GoodsType();
			type.setId(id);
			type.setTypename(typename);
			this.type = type;
		}
		
		public void ensureNotEmpty(HttpServletRequest request) throws Exception {
			//�Ȼ�ȡ���еĲ���
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
