package com.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.admin.GoodsDao;
import com.entity.Auser;
import com.entity.Goods;
import com.exception.LossInfoException;
import com.service.ServiceUtil;
import com.util.MyUtil;


@Service
public class GoodsService {
	
	@Autowired
	GoodsDao dao;
	CommonsMultipartFile file;
	Goods goods;
	
	HttpServletRequest request;
	
	//ͨ�������������������������ɾ�Ĳ�ķ������������Լ���Contorller��Ĵ��룬���жϷ������߼�Ҳ��������
	public String baseMethod(HttpServletRequest request,CommonsMultipartFile file) throws Exception {
		
		this.file = file;
		this.request = request;
		//ͨ��������������зǿ��жϣ�Ȼ��ֱ�ӵ��ô��goods�ķ���
		this.ensureNotEmpty(request);
		//ͨ�����������÷���������������if else
		String jsp = (String)this.getClass().getMethod(request.getParameter("method")+"Goods", Goods.class).invoke(this, this.goods);
		return jsp;

	}
	
	public String addGoods(Goods goods) {
		try {
			if(goods.getGoodstype_id() == 0 || goods.getName() == null || goods.getStore() == 0 || goods.getPrice() == 0.0|| goods.getPicture() == null) {
				throw new LossInfoException();
			}
			 
			
			int changed = dao.addGoods(goods);
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	public String deleteGoods(Goods goods) {
		try {
			if(goods.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.deleteGoods(goods.getId());
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	public String updateGoods(Goods goods) {
		try {
			if(goods.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.updateGoods(goods);
			this.request.setAttribute("changed", changed);
			System.out.println("ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	public String queryGoods(Goods goods) {
		try {
			if(goods.getId() == 0) {
				throw new LossInfoException();
			}
			goods = dao.queryGoods(goods.getId());
			this.request.setAttribute("type", goods);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	//�����ǹ��߷���
	public void packingGoods(int id,String name,double price, int store, int goodstype_id) throws Exception {
		Goods goods = new Goods();
		goods.setId(id);
		goods.setName(name);
		goods.setPrice(price);
		goods.setStore(store);
		goods.setGoodstype_id(goodstype_id);
		String imgName = this.saveImage();
		if(imgName != null) {
			goods.setPicture(imgName);
		}else {
			goods.setPicture("");
		}
		
		this.goods = goods;
	}
	
	public void ensureNotEmpty(HttpServletRequest request) throws Exception {
		
		//�Ȼ�ȡ���еĲ���
		String name = null;
		double price = 0.0;
		int store = 0;
		int goodstype_id = 0;
		int id = 0;
		
		
		if(!request.getParameter("id").equals("")) {
			id = Integer.valueOf(request.getParameter("id"));
		}
		
		
		if(!request.getParameter("name").equals("")) {
			name = request.getParameter("name");
		}
		
		if(!request.getParameter("price").equals("")) {
			price = Double.valueOf(request.getParameter("price"));
		}
		
		if(!request.getParameter("store").equals("")) {
			store = Integer.valueOf(request.getParameter("store"));
		}
		if(!request.getParameter("goodstype_id").equals("")) {
			goodstype_id = Integer.valueOf(request.getParameter("goodstype_id"));
		}
		
		
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		System.out.println("price:"+price);
		System.out.println("store:"+store);
		System.out.println("goodstype:"+goodstype_id);
		packingGoods(id,name,price,store,goodstype_id);
		
	}
	
	//����ͼƬ�����ش���
	public String saveImage() throws IOException {
		
		try {
			
			if(this.file.getSize() != 0) {
				InputStream in = this.file.getInputStream();
				byte[] b = new byte[in.available()];
				in.read(b);
				String filename = file.getOriginalFilename();
				
				//��ȡ���ͼƬ�ĺ�׺
				String[] realFilename = filename.split("\\.");
				String head = realFilename[0];
				String tail = realFilename[1];
				//����һ���µĿ��Ա�֤Ψһ������
				String random = String.valueOf(new Random().nextInt());
				String time = String.valueOf(new Date().getTime());
				String imgName = random+time+"."+tail;
				System.out.println(imgName);
				
				OutputStream out = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")+"img/before/"+imgName);
				out.write(b);
				//��ȥ���ľ�����Ϊ����û��close����ÿ����ӵ�ͼƬû��д�����̽����û����
				out.close();
				in.close();
				return imgName;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			System.out.println("ͼƬ����������");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
