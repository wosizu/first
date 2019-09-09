package com.util;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;



public class MyMethodInterceptor implements MethodInterceptor{


	public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("前置通知");
		proxy.invokeSuper(obj,arg2);
		System.out.println("后置通知");
		return null;
	}

}
