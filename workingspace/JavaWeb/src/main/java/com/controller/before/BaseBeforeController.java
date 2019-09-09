package com.controller.before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exception.AdminNotLoginException;
import com.exception.BeforeNotLoginException;
import com.util.MyUtil;

@RequestMapping("/before")
@Controller
public class BaseBeforeController {
	
	
	@RequestMapping("/CRUD")
	public String toQuery(HttpServletRequest request) throws AdminNotLoginException {
		
		if(request.getParameter("type") != null) {
			return "forward:/before/"+MyUtil.upperCase(request.getParameter("type"));
		}
		
		return "forward:/Error";

	}
	
	
	
	@RequestMapping("")
	public String toBefore() {
		MyUtil.getPorxy();
		return "before/main";
	}
}
