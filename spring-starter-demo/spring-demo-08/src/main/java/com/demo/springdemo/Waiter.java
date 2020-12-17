package com.demo.springdemo;

import com.demo.springdemo.anno.NeedTest;

public interface Waiter {
	@NeedTest
	public void greetTo(String clientName);	
	public void serveTo(String clientName);
}
