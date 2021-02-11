package com.example.spring.aop.original;

public class TestForumService {

	public static void main(String[] args) {
		ForumService service = new ForumServiceImpl();
		service.removeForum(11);
		service.removeTopic(21);
	}

}
