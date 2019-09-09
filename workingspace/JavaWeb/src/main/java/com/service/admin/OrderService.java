package com.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.admin.OrderDao;
import com.entity.Notice;
import com.entity.Order;
import com.exception.LossInfoException;
import com.service.ServiceUtil;
import com.util.MyUtil;


@Service
public class OrderService {
	
	@Autowired
	OrderDao dao;
		
		
	Order order;
	
	HttpServletRequest request;
	
	//ͨ�������������������������ɾ�Ĳ�ķ������������Լ���Contorller��Ĵ��룬���жϷ������߼�Ҳ��������
	public String baseMethod(HttpServletRequest request) throws Exception {
		this.request = request;
		//ͨ��������������зǿ��жϣ�Ȼ��ֱ�ӵ��ô��goods�ķ���
		this.ensureNotEmpty(request);
		//ͨ�����������÷���������������if else
		String jsp = (String)this.getClass().getMethod(request.getParameter("method")+"Order", Order.class).invoke(this, this.order);
		return jsp;
	}
	
	public String addOrder(Order order) {
		try {
			if(order.getId() == 0 || order.getAmount() == 0 || order.getOrderdate() == null || order.getStatus() == null || order.getUser_id() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.addOrder(order);
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	public String deleteOrder(Order order) {
		try {
			if(order.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.deleteOrder(order.getId());
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
////	
	public String updateOrder(Order order) {
		try {
			if(order.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.updateOrder(order);
			this.request.setAttribute("changed", changed);
			System.out.println("ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
////	
	public String queryOrder(Order order) {
		try {
			
			if(order.getId() == 0) {
				throw new LossInfoException();
			}
			
			order = dao.queryOrder(order.getId());
			
			this.request.setAttribute("type", order);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			e.printStackTrace();
			return ServiceUtil.PATH_ERROR;
		}
	}
//	
	//�����ǹ��߷���
	public void packingOrder(int id,int user_id,int amount,String status) {
		Order order = new Order();
		order.setId(id);
		order.setUser_id(user_id);
		order.setAmount(amount);
		order.setStatus(status);
		order.setOrderdate(MyUtil.getTime());
		this.order = order;
	}
	
	public void ensureNotEmpty(HttpServletRequest request) throws Exception {
		//�Ȼ�ȡ���еĲ���
		int usertable_id=0;
		int amount = 0;
		int id = 0;
		String status=null;
		
		if(!request.getParameter("id").equals("")) {
			id = Integer.valueOf(request.getParameter("id"));
		}
		if(!request.getParameter("status").equals("")) {
			status = MyUtil.changeCoded(request.getParameter("status"));
		}
		if(!request.getParameter("usertable_id").equals("")) {
			usertable_id = Integer.valueOf(request.getParameter("usertable_id"));
		}
		if(!request.getParameter("amount").equals("")) {
			amount = Integer.valueOf(request.getParameter("amount"));
		}
		
		
		
		System.out.println("id:"+id);
		System.out.println("amount:"+amount);
		System.out.println("usertable_id:"+usertable_id);
		
		packingOrder(id,usertable_id,amount,status);
		
	}
	

}
