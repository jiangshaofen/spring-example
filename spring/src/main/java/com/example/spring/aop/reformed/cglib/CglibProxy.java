package com.example.spring.aop.reformed.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);// 设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create();// 通过字节码技术动态创建子类实例
	}

	// 拦截父类所有方法的调用
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	}
// CGlib 为 ForumServiceImpl 动态创建的子类
//	com.example.spring.aop.reformed.cglib.ForumServiceImpl$$EnhancerByCGLIB$$6821a528
}
