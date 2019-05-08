package com.mateacademy.jdbctemplate.service.impl;

import com.mateacademy.jdbctemplate.dao.UserDao;
import com.mateacademy.jdbctemplate.model.User;
import com.mateacademy.jdbctemplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (userDao.findUserById(id).isPresent()) {
            return userDao.findUserById(id).get();
        }
        else {
            throw new IllegalArgumentException("Invalid id");
        }
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
