package com.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.cglib.proxy.Enhancer;

import com.dao.admin.GoodsDao;
import com.entity.Goods;
import com.service.admin.GoodsService;

public class MyUtil {
	
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		String time = formate.format(date);
		return time;
	}
	
	public static int[] getId(HttpServletRequest req,String name) {
		HttpSession session = req.getSession();
		int[] id = (int[]) session.getAttribute(name);
		return id;
	}
	
	//首字母转大写
	public static String upperCase(String str) {  
        return str.substring(0, 1).toUpperCase() + str.substring(1);  
    }
	
	//转码
	public static String changeCoded(String str) throws Exception{
		str = new String(str.getBytes("iso-8859-1"), "utf-8"); 
		return str;
	}
	
	//动态代理
	public static Object getPorxy() {
		MyMethodInterceptor daoProxy = new MyMethodInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GoodsService.class);
        enhancer.setCallback(daoProxy);
        GoodsService dao = (GoodsService)enhancer.create();
        return dao;
	}
	
	
	
			
}
