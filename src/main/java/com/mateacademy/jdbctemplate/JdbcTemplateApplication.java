package com.mateacademy.jdbctemplate;

import com.mateacademy.jdbctemplate.config.ApplicationConfig;
import com.mateacademy.jdbctemplate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JdbcTemplateApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService service = context.getBean(UserService.class);

    }
}
