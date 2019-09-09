package com.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.admin.UserDao;
import com.entity.Goods;
import com.entity.User;
import com.service.ServiceUtil;
import com.util.MyUtil;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	User user;
	
	HttpServletRequest request;
	
	//ͨ�������������������������ɾ�Ĳ�ķ������������Լ���Contorller��Ĵ��룬���жϷ������߼�Ҳ��������
	public String baseMethod(HttpServletRequest request) throws Exception {
		this.request = request;
		//ͨ��������������зǿ��жϣ�Ȼ��ֱ�ӵ��ô��goods�ķ���
		this.ensureNotEmpty(request);
		//ͨ�����������÷���������������if else
		String jsp = (String)this.getClass().getMethod(request.getParameter("method")+"User", User.class).invoke(this, this.user);
		return jsp;
		
	}
	
	public String addUser(User user) {
		int changed = dao.addUser(user);
		this.request.setAttribute("changed", changed);
		System.out.println("����ִ�����");
		return ServiceUtil.PATH_RESULT;
	}
	
	public String deleteUser(User user) {
		int changed = dao.deleteUser(user.getId());
		this.request.setAttribute("changed", changed);
		System.out.println("����ִ�����");
		return ServiceUtil.PATH_RESULT;
	}
	
	public String updateUser(User user) {
		int changed = dao.updateUser(user);
		this.request.setAttribute("changed", changed);
		System.out.println("ִ�����");
		return ServiceUtil.PATH_RESULT;
	}
	
	public String queryUser(User user) {
		user = dao.queryUser(user.getId());
		this.request.setAttribute("type", user);
		System.out.println("��������");
		System.out.println("����ִ�����");
		return ServiceUtil.PATH_RESULT;
	}
	
	
	//�����ǹ��߷���
	public void packingUser(int id ,String name,String password) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		this.user = user;
	}
		
	public void ensureNotEmpty(HttpServletRequest request) throws Exception {
		//�Ȼ�ȡ���еĲ���
		String name=null;
		int id = 0;
		String password = null;
		if(!request.getParameter("id").equals("")) {
			id = Integer.valueOf(request.getParameter("id"));
		}
		if(!request.getParameter("name").equals("")) {
			name = MyUtil.changeCoded(request.getParameter("name"));
		}
		
		if(!request.getParameter("password").equals("")) {
			password = request.getParameter("password");
		}
		
		
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		System.out.println("pwd:"+password);
		packingUser(id,name,password);
		
	}
	
	

}
