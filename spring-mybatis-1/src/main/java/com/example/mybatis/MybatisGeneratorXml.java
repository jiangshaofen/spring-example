package com.example.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MyBatis代码生成，依赖 xml 配置信息生成。
 * 
 * @author jiang
 *
 */
public class MybatisGeneratorXml {

	public static void main(String[] args) {
		try
		{
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(MybatisGeneratorXml.class.getResourceAsStream("/generatorConfig.xml"));
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("+++++++++++  MybatisGenerator End  +++++++++");
		}
		catch (IOException ex)
		{
			System.err.println("IOException:" + ex.toString());
		}
		catch (XMLParserException ex)
		{
			System.err.println("XMLParserException:" + ex.toString());
		}
		catch (InvalidConfigurationException ex)
		{
			System.err.println("InvalidConfigurationException:" + ex.toString());
		}
		catch (SQLException ex)
		{
			System.err.println("SQLException:" + ex.toString());
		}
		catch (InterruptedException ex)
		{
			System.err.println("InterruptedException:" + ex.toString());
		}
	}
}

// 官方代码
// List<String> warnings = new ArrayList<String>();
// boolean overwrite = true;
// File configFile = new File("mybatis-generator.xml");
// ConfigurationParser cp = new ConfigurationParser(warnings);
// Configuration config = cp.parseConfiguration(configFile);
// DefaultShellCallback callback = new
// DefaultShellCallback(overwrite);
// MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
// callback, warnings);
// myBatisGenerator.generate(null);