/**
 * spring与mybatis 整合案例
 * 
 * 1、采用MapperScannerConfigurer，它将会查找类路径下的映射器并自动将它们创建成MapperFactoryBean。
 * 
 * 2、采用接口org.apache.ibatis.session.SqlSession的实现类org.mybatis.spring.SqlSessionTemplate。
 * mybatis中, sessionFactory可由SqlSessionFactoryBuilder.来创建。MyBatis-Spring 中，使用了SqlSessionFactoryBean来替代。
 * SqlSessionFactoryBean有一个必须属性dataSource，另外其还有一个通用属性configLocation（用来指定mybatis的xml配置文件路径）。
 * 
 * 3、采用抽象类org.mybatis.spring.support.SqlSessionDaoSupport提供SqlSession。
 * @author NJJH
 *
 */
package com.example.mybatis;