package com.demo.springdemo.introduce;

public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> MethodPerformance = new ThreadLocal<>();

	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformance mp = MethodPerformance.get();

		if(mp == null){
			mp = new MethodPerformance(method);
			MethodPerformance.set(mp);

		}else{
		    mp.reset(method);	
		}
	}

	public static void end() {
		System.out.println("end monitor...");
		MethodPerformance mp = MethodPerformance.get();
		mp.printPerformance();
	}
}
