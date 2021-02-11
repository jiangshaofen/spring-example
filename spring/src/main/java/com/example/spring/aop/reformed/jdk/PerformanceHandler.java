package com.example.spring.aop.reformed.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现 InvocationHandler
public class PerformanceHandler implements InvocationHandler {
	private Object target;// 目标业务类

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());

		// 通过反射方法调用业务类的目标方法
		Object obj = method.invoke(target, args);

		PerformanceMonitor.end();
		return obj;
	}

}
