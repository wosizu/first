package com.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.admin.TypeService;


@Controller
public class GoodsTypeController {
	
	
	@Autowired
	TypeService service;
	
	@RequestMapping("admin/Type")
	public String user(HttpServletRequest request) throws Exception {
		String jsp = service.baseMethod(request);
		return jsp;
	}
	
}
