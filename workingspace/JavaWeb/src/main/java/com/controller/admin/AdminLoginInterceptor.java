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
		
			//����ָ����ǰ�˴��������auserΪname
//			String auser = request.getParameter(PARAMETER_USERNAME);
			
			
			//���������Ԥ��ѯ
			String cookiePwd = this.getCookiePwd(request, auser);
			String sessionPwd = this.getSessionPwd(request, auser);
	
			
			if(cookiePwd != null && sessionPwd != null) {
				
				if(cookiePwd.equals(sessionPwd)) {
					System.out.println("������ȷ��������ת");
					request.setAttribute("auser", auser);
					return true;
					
				}else {
					System.out.println("���벻��ȷ�����ص�½ҳ��");
					response.sendRedirect(PATH_LOGIN);
					System.out.println("���ص���½ҳ����");
					return false;
				}
				
			}else if(cookiePwd != null && sessionPwd ==null) {
				
				//û��session���ʹ����ݿ��в�ѯ
				sessionPwd = this.queryDatabase(auser);
				if(sessionPwd.equals(cookiePwd)) {
					System.out.println("������ȷ������ִ��");
					request.getSession().setAttribute(auser, sessionPwd);
					System.out.println("session�������");
					//����Ҳ�Ǹ�������
					request.setAttribute("auser", auser);
					System.out.println("admin�û����������");
					return true;
				}else {
					System.out.println("������󣬷��ص�½ҳ��");
					response.sendRedirect(PATH_LOGIN);
					return false;
				}
				
			}else if(cookiePwd == null && sessionPwd == null) {
				
				//�ж��Ƿ�����������û���
				System.out.println("û�е�½��,�����б������ݿ�ƥ��!");
				//����Ҳ�������������password
				if(request.getParameter(auser) != null && request.getParameter(PARAMETER_PASSWORD) != null) {
					String password = this.queryDatabase(auser);
					
					
					//�ж��Ƿ���ȷ.....��������֪�ַ�����ƥ��δ֪�Ŀ��Ա����ָ���쳣,,����if��Ƕ���е������������˼��
					if(auser.equals(request.getParameter("auser")) && request.getParameter("password").equals(password)) {
						System.out.println("����ƥ����ȷ�������������");
						Cookie[] cookieArray = request.getCookies();
						
						Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
						cookie.setMaxAge(COOKIE_MAX_AGE);
						cookie.setPath(COOKIE_PATH);
						response.addCookie(cookie);
						
						cookie = new Cookie(auser,password);
						cookie.setMaxAge(COOKIE_MAX_AGE);
						cookie.setPath(COOKIE_PATH);
						System.out.println("cookie max age��30����");
						response.addCookie(cookie);
						System.out.println("cookie�������");
						
						HttpSession session = request.getSession();
						session.setAttribute(auser, password);
						System.out.println("session���óɹ�");
						request.setAttribute("auser", auser);
						System.out.println("��½���������");
						return true;
					}else {
						System.out.println("username:"+request.getParameter(PARAMETER_USERNAME));
						System.out.println("password:"+request.getParameter(PARAMETER_PASSWORD));
						System.out.println("������ƥ����󣬷��ص�½ҳ��");
						response.sendRedirect(PATH_LOGIN);						
						return false;
					}
				}else{
					
					System.out.println("�������ǿյģ�ת������½ҳ��");
					response.sendRedirect(PATH_LOGIN);
					return false;
				}
				
			}else if(cookiePwd == null && sessionPwd != null) {
				
				if(auser.equals(request.getParameter("auser")) && request.getParameter("password").equals(sessionPwd)) {
					System.out.println("����ƥ����ȷ�������������");
					Cookie[] cookieArray = request.getCookies();
					
					Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
					cookie.setMaxAge(COOKIE_MAX_AGE);
					cookie.setPath(COOKIE_PATH);
					response.addCookie(cookie);
					
					cookie = new Cookie(auser,"1234");
					cookie.setPath(COOKIE_PATH);
					cookie.setMaxAge(COOKIE_MAX_AGE);
					System.out.println("cookie max age��30����");
					response.addCookie(cookie);
					System.out.println("cookie�������");
					
					request.setAttribute("auser", auser);
					System.out.println("��½���������");
					return true;
				}else {
					System.out.println("username:"+request.getParameter(PARAMETER_USERNAME));
					System.out.println("password"+request.getParameter(PARAMETER_PASSWORD));
					System.out.println("������ƥ����󣬷��ص�½ҳ��");
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
	
	
	
	//��ȡcookie�б��������
		public String getCookiePwd(HttpServletRequest request,String cookieName) {
			
			Cookie[] cookie = request.getCookies();
			
			if(cookie != null) {
				String cookiePwd = null;
				for(Cookie c:cookie){
					if(c.getName().equals(cookieName)) {
						cookiePwd = c.getValue();
						//��ѯ����ֱ�ӷ������ֵ
						return cookiePwd;
					}
				}
			}
			//ִ�е������˵��û���ڿͻ��˻������ѯ�����Է���null
			return null;
			
		}
		
		//��ȡsession�б��������
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
		
		//�����ݿ������
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
