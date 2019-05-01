package com.mateacademy.jdbctemplate.controller.service.impl;

import com.mateacademy.jdbctemplate.controller.dao.UserDao;
import com.mateacademy.jdbctemplate.controller.service.UserService;
import com.mateacademy.jdbctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
