package com.mateacademy.jdbctemplate.controller.service.impl;

import com.mateacademy.jdbctemplate.config.ApplicationConfig;
import com.mateacademy.jdbctemplate.controller.service.UserService;
import com.mateacademy.jdbctemplate.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserServiceImplTest {
    @Autowired
    private UserService service;

    private User user;

    @Before
    public void setUp() {
        user = new User().setName("Test").setAge(18);
    }

    @After
    public void tearDrop(){
        service.deleteUser(user);
    }

    @Test
    public void shouldCreateUserInDatabase() {
        service.createUser(user);
        Optional<User> expectedUser = service.findUserById(user.getId());
        Assert.assertEquals(user, expectedUser.get());
    }

    @Test
    public void shouldFindUserById() {
        Long targetId = service.createUser(user);
        Optional<User> expectedUser = service.findUserById(targetId);
        Assert.assertEquals(user, expectedUser.get());
    }

    @Test
    public void shouldUpdateUserByReference() {
        Long targetId = service.createUser(user);
        user.setName("Updated");
        user.setAge(100);
        service.updateUser(user);
        Assert.assertEquals(user, service.findUserById(targetId).get());
    }

    @Test
    public void shouldDeleteUserByReference() {
        service.createUser(user);
        service.deleteUser(user);
        Assert.assertFalse(service.getAllUsers().contains(user));
    }

    @Test
    public void shouldDeleteUserById() {
        Long targetId = service.createUser(user);
        service.deleteUser(targetId);
        Assert.assertFalse(service.getAllUsers().contains(user));
    }

    @Test
    public void shouldReturnListOfUsers() {
        service.createUser(user);
        Assert.assertEquals(service.getAllUsers().size(), 1);
        service.deleteUser(user);
        Assert.assertEquals(service.getAllUsers().size(), 0);
    }
}
