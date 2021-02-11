package com.example.spring.resource;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class ResourceExample {

	public static void main(String[] args) {
		try {
			System.err.println("FileSystemResource ===================================================");
			String filePath = "E:\\DevSpring\\spring-example\\spring\\file.txt";
			Resource res = new FileSystemResource(filePath);
			String fileName = res.getFilename();
			String path = res.getFile().getPath();
			System.out.println("FileSystemResource fileName=" + fileName);
			System.out.println("FileSystemResource path=" + path);
			String content = FileCopyUtils.copyToString(new InputStreamReader(res.getInputStream(), "UTF-8"));
			System.out.println("FileSystemResource content:" + content);
			
			System.err.println("ClassPathResource ===================================================");
			res = new ClassPathResource("com/example/spring/resource/file1.txt");
			EncodedResource encRes = new EncodedResource(res, "UTF-8");// 指定编码
			fileName = res.getFilename();
			path = res.getFile().getPath();
			System.out.println("ClassPathResource fileName=" + fileName);
			System.out.println("ClassPathResource path=" + path);
			content = FileCopyUtils.copyToString(encRes.getReader());
			System.out.println("ClassPathResource content:" + content);
			
			System.err.println("ByteArrayResource ===================================================");
			String testStr="这是测试byte用的字符串内容";
			res=new ByteArrayResource(testStr.getBytes()); 
			System.out.println("ByteArrayResource testStr.contentLength=" + res.contentLength());
			System.out.println("ByteArrayResource testStr.isFile=" + res.isFile());
			
			System.err.println("UrlResource ===================================================");
			res = new UrlResource("http://www.webxml.com.cn/WebServices/WeatherWS.asmx");
			System.out.println("urlResource.getFilename()=" + res.getFilename());
			System.out.println("urlResource.getDescription()=" + res.getDescription());
			content = FileCopyUtils.copyToString(new InputStreamReader(res.getInputStream(), "UTF-8"));
			System.out.println("urlResource content:" + content);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
