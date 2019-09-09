package com.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.admin.GoodsDao;
import com.entity.Goods;
import com.service.admin.GoodsService;

@Controller
public class GoodsController {
	
	
	@Autowired
	GoodsService service;
	
	
	@RequestMapping("/admin/Goods")
	public String goods(@RequestParam("picture") CommonsMultipartFile file ,HttpServletRequest request) throws Exception {
		
		//重构后这里太干净了，完美
		System.out.println("开始绕圈");
		String jsp = service.baseMethod(request,file);
		System.out.println("绕圈结束");
		
		
//		//获取文件名
//		String name = file.getOriginalFilename();
//		InputStream in = file.getInputStream();
//		byte[] img = new byte[in.available()];
//		in.read(img);
//		
//		//获取保存路径
//		File file2 = new File(request.getSession().getServletContext().getRealPath("/")+"/img/"+name);
//		file2.createNewFile();
//		OutputStream out = new FileOutputStream(file2);
//		out.write(img);
		
		
		return jsp;
	}
	
	
}
