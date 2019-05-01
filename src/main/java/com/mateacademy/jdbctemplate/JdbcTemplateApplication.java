package com.mateacademy.jdbctemplate;

import com.mateacademy.jdbctemplate.config.ApplicationConfig;
import com.mateacademy.jdbctemplate.controller.service.UserService;
import com.mateacademy.jdbctemplate.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JdbcTemplateApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService service = context.getBean(UserService.class);
        User petya = new User().setAge(20).setName("petya");
        service.createUser(petya);
        System.out.println(petya.getId());
        context.close();
    }
}
