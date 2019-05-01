package com.mateacademy.jdbctemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.mateacademy.jdbctemplate")
@PropertySource("application.properties")
public class ApplicationConfig {

    @Value("${url}")
    private String URL;
    @Value("${user}")
    private String USER;
    @Value("${driver}")
    private String DRIVER;
    @Value("${password}")
    private String PASSWORD;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(URL);
        driverManagerDataSource.setUsername(USER);
        driverManagerDataSource.setPassword(PASSWORD);
        driverManagerDataSource.setDriverClassName(DRIVER);
        return driverManagerDataSource;
    }
}
