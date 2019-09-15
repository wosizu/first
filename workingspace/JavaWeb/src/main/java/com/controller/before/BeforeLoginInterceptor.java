package com.controller.before;


import com.dao.admin.UserDao;
import com.entity.User;
import com.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class BeforeLoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserDao dao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int userId=0;
        String password=null;
        HttpSession session = request.getSession();
        Cookie[] cookie = request.getCookies();
        //判断cookie是否大于二，小于二说明并没有添加cookie
        if(cookie.length >= 2){
            System.out.println("cookie大于二尝试获取cookie");
            for(Cookie c:cookie){
                System.out.println(c.getName());
                if("userId".equals(c.getName())){
                    System.out.println("id:"+c.getValue());
                    userId = Integer.valueOf(c.getValue());
                }
            }

            for(Cookie c:cookie){
                if(String.valueOf(userId).equals(c.getName())){
                    password = c.getValue();
                }
            }
        }

        //上面获取了用户名与用户密码
        //下面就查询数据库进
        if(userId != 0 && password != null){
            User user = dao.queryUser(userId);
            //下面进行判断
            if(password.equals(user.getPassword())) {
                System.out.println("匹配正确");
                //向request中添加用户信息，以便JSP页面中可以方便的获取用户信息
                request.setAttribute("user",user);
                return true;
            }
        }else {
            //判断传的密码参数是否正确
            try{
                if(dao.queryUser(Integer.valueOf(request.getParameter("userId"))).getPassword().equals(request.getParameter("password"))){
                    System.out.println("没有cookie尝试设置cookie");
                    Cookie c = new Cookie("userId", request.getParameter("userId"));
                    response.addCookie(c);
                    c = new Cookie(request.getParameter("userId"), request.getParameter("password"));
                    response.addCookie(c);
                    //向request中添加用户信息，以便JSP页面中可以方便的获取用户信息
                    User user = dao.queryUser(Integer.valueOf(request.getParameter("userId")));
                    request.setAttribute("user",user);
                    return true;
                }else{
                    System.out.println("密码匹配错误");
                    return false;
                }


            }catch (Exception e){
                System.out.println("没有密码参数");
                return false;
            }

        }
        System.out.println("暂时没有设计");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
