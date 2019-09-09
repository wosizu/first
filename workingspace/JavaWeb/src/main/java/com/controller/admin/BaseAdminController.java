package com.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.exception.AdminNotLoginException;
import com.util.MyUtil;

@RequestMapping("/admin")
@Controller
public class BaseAdminController {
	
	
	@RequestMapping("CRUD")
	public String toQuery(HttpServletRequest request) throws AdminNotLoginException, Exception {
		
		/*
		 * 这里我只是进行非空判断，然后就直接根据传入的值进行转发，对有效性没有进行验证
		 * 如果要验证就成了下面那每次要增加一种请求就要修改这里的代码，就会又臭又长
		 * */
		if(request.getParameter("type") != null) {
			return "forward:/admin/"+MyUtil.upperCase(request.getParameter("type"));
		}
		
		return "forward:/Error";

	}
	
	
	
	
	
	
	@RequestMapping("")
	public String toAdmin() {
		return "/admin/admin";
	}
	
	@RequestMapping("login")
	public String login() {
		return "/admin/login";
	}
	
	
}
