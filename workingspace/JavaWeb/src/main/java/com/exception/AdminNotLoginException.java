package com.exception;

public class AdminNotLoginException extends Exception{
	
	public AdminNotLoginException() {
		super("管理员用户未登陆");
	}
	
}
