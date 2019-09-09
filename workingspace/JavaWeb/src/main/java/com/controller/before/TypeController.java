package com.controller.before;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.before.QueryByType;

@Controller
public class TypeController {
	
	@Autowired
	QueryByType service;
	
	@RequestMapping("/before/type")
	public String query(HttpServletRequest request) {
		String jsp = service.query(request);
		return jsp;
	}
	
}
