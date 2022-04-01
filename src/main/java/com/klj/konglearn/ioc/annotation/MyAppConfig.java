package com.klj.konglearn.ioc.annotation;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.klj.konglearn.demo.transaction.JdbcDemo.*;

@Configuration
@ComponentScan("com.klj.konglearn.ioc")
@EnableTransactionManagement
public class MyAppConfig {

    @Bean
    public DataSource dataSource() {
        // configure and return the necessary JDBC DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {

        //return new DataSourceTransactionManager(dataSource());
        return null;
    }
}
