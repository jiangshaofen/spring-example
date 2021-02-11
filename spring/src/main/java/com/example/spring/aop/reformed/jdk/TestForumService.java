package com.example.spring.aop.reformed.jdk;

import java.lang.reflect.Proxy;

public class TestForumService {

	public static void main(String[] args) {
		// 希望被代理的目标业务类
		ForumService target = new ForumServiceImpl();
		// 将目标业务类和横切代码编织到一起
		PerformanceHandler handler = new PerformanceHandler(target);
		// 根据编织了目标业务类逻辑和性能监视横切逻辑的 InvocationHandler 实例创建代理实例
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		
		proxy.removeForum(11);
		proxy.removeTopic(21);
	}

}
