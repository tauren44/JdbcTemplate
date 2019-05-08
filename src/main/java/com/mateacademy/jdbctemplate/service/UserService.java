package com.mateacademy.jdbctemplate.service;

import com.mateacademy.jdbctemplate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Long createUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUserByReference(User user);
    void deleteUserById(Long id);
    List<User> getAllUsers();
}
