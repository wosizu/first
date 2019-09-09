package com.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.NoticeService;
import com.service.admin.OrderService;


@Controller
public class OrderController {
	@Autowired
	OrderService service;
	
	@RequestMapping("/admin/Order")
	public String user(HttpServletRequest request) throws Exception {
		String jsp = service.baseMethod(request);
		return jsp;
	}
}
