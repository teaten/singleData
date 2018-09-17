package com.example.demo.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//绑定datasource和factory,以及扫描路径mapper文件
@Configuration
public class SessionFactoryConfiguration {
	@Value("${mybatis_config_file}")
	private String mybatisConfigFilePathpath;
	
	@Value("${mapper_path}")
	private String mapperPath;
	
	@Value("${entity_mapper}")
	private String entityPackage;
	@Autowired
	@Qualifier("datasource")
	private DataSource dataSource;

	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean creatSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean=	new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePathpath));
		//mapper语句转换成sql语句，结果返回
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
		//mapper文件位置
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		//绑定数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		//实体类
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactoryBean;
	}
}
