package com.example.spring.aop.reformed.jdk;

public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		System.out.println("模拟删除 Topic 记录：" + topicId);
		try {
			Thread.sleep(23);
			System.out.println("threadName：" + Thread.currentThread().getName());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void removeForum(int forumId) {
		System.out.println("模拟删除 Froum 记录：" + forumId);
		try {
			Thread.sleep(44);
			System.out.println("threadName：" + Thread.currentThread().getName());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
