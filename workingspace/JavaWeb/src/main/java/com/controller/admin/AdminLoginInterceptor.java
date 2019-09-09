package com.controller.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminLoginInterceptor implements HandlerInterceptor  {

	public static final int COOKIE_MAX_AGE = 60 * 30;
	public static final String PARAMETER_USERNAME = "auser";
	public static final String PARAMETER_PASSWORD = "password";
	public static final String PATH_LOGIN = "admin/login";
	public static final String auser = "auser";
	public static final String COOKIE_PATH = "/JavaWeb/admin";
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			//这里指定了前端传入必须以auser为name
//			String auser = request.getParameter(PARAMETER_USERNAME);
			
			
			//这里进行了预查询
			String cookiePwd = this.getCookiePwd(request, auser);
			String sessionPwd = this.getSessionPwd(request, auser);
	
			
			if(cookiePwd != null && sessionPwd != null) {
				
				if(cookiePwd.equals(sessionPwd)) {
					System.out.println("密码正确，立即跳转");
					request.setAttribute("auser", auser);
					return true;
					
				}else {
					System.out.println("密码不正确，返回登陆页面");
					response.sendRedirect(PATH_LOGIN);
					System.out.println("返回到登陆页面了");
					return false;
				}
				
			}else if(cookiePwd != null && sessionPwd ==null) {
				
				//没有session，就从数据库中查询
				sessionPwd = this.queryDatabase(auser);
				if(sessionPwd.equals(cookiePwd)) {
					System.out.println("密码正确，继续执行");
					request.getSession().setAttribute(auser, sessionPwd);
					System.out.println("session设置完毕");
					//这里也是个死代码
					request.setAttribute("auser", auser);
					System.out.println("admin用户名设置完成");
					return true;
				}else {
					System.out.println("密码错误，返回登陆页面");
					response.sendRedirect(PATH_LOGIN);
					return false;
				}
				
			}else if(cookiePwd == null && sessionPwd == null) {
				
				//判断是否带着密码与用户名
				System.out.println("没有登陆过,将进行表单与数据库匹配!");
				//这里也是死代码必须是password
				if(request.getParameter(auser) != null && request.getParameter(PARAMETER_PASSWORD) != null) {
					String password = this.queryDatabase(auser);
					
					
					//判读是否正确.....这里用已知字符串来匹配未知的可以避免空指针异常,,三个if的嵌套有点垃圾代码的意思了
					if(auser.equals(request.getParameter("auser")) && request.getParameter("password").equals(password)) {
						System.out.println("密码匹配正确，允许继续访问");
						Cookie[] cookieArray = request.getCookies();
						
						Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
						cookie.setMaxAge(COOKIE_MAX_AGE);
						cookie.setPath(COOKIE_PATH);
						response.addCookie(cookie);
						
						cookie = new Cookie(auser,password);
						cookie.setMaxAge(COOKIE_MAX_AGE);
						cookie.setPath(COOKIE_PATH);
						System.out.println("cookie max age：30分钟");
						response.addCookie(cookie);
						System.out.println("cookie设置完毕");
						
						HttpSession session = request.getSession();
						session.setAttribute(auser, password);
						System.out.println("session设置成功");
						request.setAttribute("auser", auser);
						System.out.println("登陆名设置完毕");
						return true;
					}else {
						System.out.println("username:"+request.getParameter(PARAMETER_USERNAME));
						System.out.println("password:"+request.getParameter(PARAMETER_PASSWORD));
						System.out.println("表单密码匹配错误，返回登陆页面");
						response.sendRedirect(PATH_LOGIN);						
						return false;
					}
				}else{
					
					System.out.println("表单数据是空的，转发到登陆页面");
					response.sendRedirect(PATH_LOGIN);
					return false;
				}
				
			}else if(cookiePwd == null && sessionPwd != null) {
				
				if(auser.equals(request.getParameter("auser")) && request.getParameter("password").equals(sessionPwd)) {
					System.out.println("密码匹配正确，允许继续访问");
					Cookie[] cookieArray = request.getCookies();
					
					Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
					cookie.setMaxAge(COOKIE_MAX_AGE);
					cookie.setPath(COOKIE_PATH);
					response.addCookie(cookie);
					
					cookie = new Cookie(auser,"1234");
					cookie.setPath(COOKIE_PATH);
					cookie.setMaxAge(COOKIE_MAX_AGE);
					System.out.println("cookie max age：30分钟");
					response.addCookie(cookie);
					System.out.println("cookie设置完毕");
					
					request.setAttribute("auser", auser);
					System.out.println("登陆名设置完毕");
					return true;
				}else {
					System.out.println("username:"+request.getParameter(PARAMETER_USERNAME));
					System.out.println("password"+request.getParameter(PARAMETER_PASSWORD));
					System.out.println("表单密码匹配错误，返回登陆页面");
					response.sendRedirect(PATH_LOGIN);						
					return false;
				}
			}
			response.sendRedirect(PATH_LOGIN);
			return false;
			
			
		}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	//获取cookie中保存的密码
		public String getCookiePwd(HttpServletRequest request,String cookieName) {
			
			Cookie[] cookie = request.getCookies();
			
			if(cookie != null) {
				String cookiePwd = null;
				for(Cookie c:cookie){
					if(c.getName().equals(cookieName)) {
						cookiePwd = c.getValue();
						//查询到就直接返回这个值
						return cookiePwd;
					}
				}
			}
			//执行到这里就说明没有在客户端缓存里查询到所以返回null
			return null;
			
		}
		
		//获取session中保存的密码
		public String getSessionPwd(HttpServletRequest request,String sessionName) {
			
			HttpSession session = request.getSession();
			String sessionPwd = null;
			if(session.getValue("auser") != null) {
				
				sessionPwd = String.valueOf(session.getValue(sessionName));
				
				return sessionPwd;
			}
			System.out.println("session is null");
			return null;
			
		}
		
		//从数据库查数据
		public String queryDatabase(String name) throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ectest?serverTimezone=GMT%2B8", "root", "123456");
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("select password from auser where name='"+name+"'");
			result.next();
			String pwd = result.getString(1);
			return pwd;
		}
		

}
