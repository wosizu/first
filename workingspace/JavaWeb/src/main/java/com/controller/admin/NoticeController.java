package com.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.NoticeService;

@Controller
public class NoticeController {

		@Autowired
		NoticeService service;
		
		@RequestMapping("/admin/Notice")
		public String user(HttpServletRequest request) throws Exception {
			String jsp = service.baseMethod(request);
			return jsp;
		}
}

