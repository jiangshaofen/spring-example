package com.example.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.JavaTypeResolverConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MyBatis代码生成，纯 java 信息生成。
 * 
 * @author jiang
 *
 */
public class MybatisGeneratorJava {

	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true; // 覆盖已有文件
		Configuration config = new Configuration(); // 代码生成器的配置

		/* 初始化代码生成器的上下文环境 */
		Context context = new Context(ModelType.FLAT);
		context.setId("contextMySQL");//唯一ID
		context.setTargetRuntime("MyBatis3Simple");//MyBatis3，MyBatis3Simple 不生成和Example查询有关的内容,同86行单个属性配置一样的效果
		context.addProperty("javaFileEncoding", "UTF-8");
		
		/* 插件配置 */
		PluginConfiguration pluginConfiguration=new PluginConfiguration();
		pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
		context.addPluginConfiguration(pluginConfiguration);
		
		/* 注释配置 */
		CommentGeneratorConfiguration commentGeneratorConfiguration=new CommentGeneratorConfiguration();
		commentGeneratorConfiguration.addProperty("suppressAllComments", "ture");
		commentGeneratorConfiguration.addProperty("suppressDate", "true");
		context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

		/* JDBC 配置 */
		JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
		jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
		jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&useSSL=false");
		jdbcConnectionConfiguration.setUserId("root");
		jdbcConnectionConfiguration.setPassword("root");
		context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

		/* 类型解析配置  */
		JavaTypeResolverConfiguration  javaTypeResolverConfiguration=new JavaTypeResolverConfiguration();
		javaTypeResolverConfiguration.addProperty("forceBigDecimals", "true");//把JDBC DECIMAL 和 NUMERIC 类型解析为java.math.BigDecimal
		context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
		
		/* 生成 entity 类 */
		JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
		javaModelGeneratorConfiguration.setTargetProject("src");  //maven for:src/main/java
		javaModelGeneratorConfiguration.setTargetPackage("com.baosight.sm.domain");
		javaModelGeneratorConfiguration.addProperty("rootClass", "com.baosight.sm.MainClass");
		context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

		/* 生成 xml 文件 */
		SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
		sqlMapGeneratorConfiguration.setTargetProject("src");
		sqlMapGeneratorConfiguration.setTargetPackage("com.baosight.sm.mapper");
		context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

		/* 生成 mapper 接口 */
		JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
		javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
		javaClientGeneratorConfiguration.setTargetProject("src");
		javaClientGeneratorConfiguration.setTargetPackage("com.baosight.sm.mapper");
		javaClientGeneratorConfiguration.addProperty("rootInterface", "com.baosight.sm.MainInterface");
		context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

		/* 设置需要生成代码的表名称 */
		TableConfiguration tableConfiguration = new TableConfiguration(context);
		tableConfiguration.setSchema("sampledb");
		tableConfiguration.setTableName("t_user");
		tableConfiguration.setDomainObjectName("User"); 
//		tableConfiguration.setCountByExampleStatementEnabled(false);
//		tableConfiguration.setSelectByExampleStatementEnabled(false);
//		tableConfiguration.setUpdateByExampleStatementEnabled(false);
//		tableConfiguration.setDeleteByExampleStatementEnabled(false);
		
		
		context.addTableConfiguration(tableConfiguration);

		/* 输出上下文环境的内容 */
//		Document doc= new Document("aa");
//		doc.setRootElement(new XmlElement("ss"));
//		String xml = context.getXmlFormatter().getFormattedContent(doc);//toXmlElement().getFormattedContent(1);
//		System.out.println(xml);// 输出的上下文环境的内容

		/* 将上下文环境添加到代码生成器配置中 */
		config.addContext(context);

		/* 生成代码 */
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator;
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("+++++++++++  MybatisGenerator End  +++++++++");
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// 输出的上下文环境的内容：
//<context defaultModelType="flat" id="context" targetRuntime="MyBatis3Simple">
//<property name="javaFileEncoding" value="UTF-8" />
//<jdbcConnection connectionURL="jdbc:MySQL://127.0.0.1:3306/jeewell" driverClass="com.mysql.jdbc.Driver" password="root" userId="root" />
//<javaModelGenerator targetPackage="com.well.module.user.entity" targetProject="src/main/java">
//  <property name="rootClass" value="com.well.kernel.mybatis.persistence.ABaseEntity" />
//</javaModelGenerator>
//<sqlMapGenerator targetPackage="com.well.module.user.mapper" targetProject="src/main/java" />
//<javaClientGenerator targetPackage="com.well.module.user.mapper" targetProject="src/main/java" type="XMLMAPPER" />
//<table tableName="user" />
//</context>
//其实就是相等于用纯 Java 代码实现了 generator 的 xml 配置文件。
//使用纯 Java 代码的好处就是很多值可以在代码中自定义，方便在代码中进行拓展。
//这样做的话，我就可以在后台管理系统中增加代码生成器的功能，管理在页面中配置生成的参数，
//就可以生成自己需要的代码，而不需要每次通过修改配置文件去生成自己需要的代码了。