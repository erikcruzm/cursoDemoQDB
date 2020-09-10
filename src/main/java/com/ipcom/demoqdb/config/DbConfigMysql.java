package com.ipcom.demoqdb.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfigMysql {
	
	@Bean(name = "dataSourceMySql")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource dataSourceMySql() {
        DataSource ds1 = DataSourceBuilder.create().build();
        return ds1;
    }

}
