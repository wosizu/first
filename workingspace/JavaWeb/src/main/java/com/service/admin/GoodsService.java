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
	
	//通过这个方法来调用其他几个增删改查的方法，这样可以减少Contorller类的代码，把判断方法的逻辑也放在这里
	public String baseMethod(HttpServletRequest request,CommonsMultipartFile file) throws Exception {
		
		this.file = file;
		this.request = request;
		//通过这个方法来进行非空判断，然后直接调用打包goods的方法
		this.ensureNotEmpty(request);
		//通过反射来调用方法，这样来减少if else
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
			System.out.println("方法执行完毕");
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
			System.out.println("方法执行完毕");
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
			System.out.println("执行完毕");
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
			System.out.println("方法执行完毕");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
	
	//下面是工具方法
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
		
		//先获取所有的参数
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
	
	//保存图片到本地磁盘
	public String saveImage() throws IOException {
		
		try {
			
			if(this.file.getSize() != 0) {
				InputStream in = this.file.getInputStream();
				byte[] b = new byte[in.available()];
				in.read(b);
				String filename = file.getOriginalFilename();
				
				//获取这个图片的后缀
				String[] realFilename = filename.split("\\.");
				String head = realFilename[0];
				String tail = realFilename[1];
				//构造一个新的可以保证唯一的名称
				String random = String.valueOf(new Random().nextInt());
				String time = String.valueOf(new Date().getTime());
				String imgName = random+time+"."+tail;
				System.out.println(imgName);
				
				OutputStream out = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")+"img/before/"+imgName);
				out.write(b);
				//我去他的就是因为这里没有close所以每次添加的图片没有写进磁盘结果都没有了
				out.close();
				in.close();
				return imgName;
			}else {
				return null;
			}
			
		}catch(Exception e) {
			System.out.println("图片处理有问题");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
