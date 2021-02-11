package com.example.spring.aop.reformed.cglib;

public class TestForumService {

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		// 通过动态生成子类的方式创建代理类
		ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
		
		forumService.removeForum(11);
		forumService.removeTopic(21);
	}

}
