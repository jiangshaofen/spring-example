package com.example.spring.resourceLoader;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 资源加载器.
 * @author jiang
 *
 */
public class FileLoadertExample {

	public static void main(String[] args) {
		try {
			// spring 标准实现
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			// 加载所有类包 com.example及子孙包下的以xml为后缀的资源
			Resource resources[] = resolver.getResources("classpath*:com/example/**/*.xml");
			for (Resource resource : resources) {
				System.out.println("resource.description:" + resource.getDescription());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
