package com.exception;

public class BeforeNotLoginException extends Exception{
	
	public BeforeNotLoginException() {
		super("前台用户未登陆");
	}
	 
}
