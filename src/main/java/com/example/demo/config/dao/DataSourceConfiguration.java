package com.example.demo.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//mapper扫描路径
@MapperScan("/mapper/**.xml")
public class DataSourceConfiguration {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.username}")
	private String user;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.password}")
	private String password;

	@Bean(name="datasource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(jdbcDriver);
		comboPooledDataSource.setJdbcUrl(jdbcUrl);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);
		comboPooledDataSource.setAutoCommitOnClose(false);
		return comboPooledDataSource;
	}
}
