package com.example.spring.factoryBean;
 
/**
 * FactoryBean 工厂类接口可提供定制实例化 Bean 的逻辑，当配置文件中的 <bean> 的 class 属性配置的实现类是
 * factoryBean 时， 通过 getBean()方法返回的不是 factoryBean 本身，而是 factoryBean#getObject()方法返回的对象，
 * 相当于 FactoryBean#getObject 代理了 getBean() 方法。
 * 
 * 如果用户希望获取 CarFactoryBean 的实例，则需要在使用 getBean(beanName) 方法时显式地在 beanName 前加上 "&"
 * 前缀：getBean("&car")
 */