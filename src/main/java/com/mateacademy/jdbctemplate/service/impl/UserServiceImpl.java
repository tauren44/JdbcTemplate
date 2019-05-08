package com.mateacademy.jdbctemplate.service.impl;

import com.mateacademy.jdbctemplate.dao.UserDao;
import com.mateacademy.jdbctemplate.service.UserService;
import com.mateacademy.jdbctemplate.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public Long createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id).get();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserByReference(User user) {
        userDao.deleteUserByReference(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
