package com.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.service.admin.GoodsService;

@Controller("adminGoodsController")
public class GoodsController {
	
	
	@Autowired
	GoodsService service;
	
	
	@RequestMapping("/admin/Goods")
	public String goods(@RequestParam("picture") CommonsMultipartFile file ,HttpServletRequest request) throws Exception {
		
		//这就是重构后的代码
		System.out.println("开始绕圈");
		String jsp = service.baseMethod(request,file);
		System.out.println("结束绕圈");
		
		
//		获取文件名
//		String name = file.getOriginalFilename();
//		InputStream in = file.getInputStream();
//		byte[] img = new byte[in.available()];
//		in.read(img);
//		
//		获取保存路径
//		File file2 = new File(request.getSession().getServletContext().getRealPath("/")+"/img/"+name);
//		file2.createNewFile();
//		OutputStream out = new FileOutputStream(file2);
//		out.write(img);
		
		
		return jsp;
	}
	
	
}
