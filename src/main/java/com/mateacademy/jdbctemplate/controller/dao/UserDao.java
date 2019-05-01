package com.mateacademy.jdbctemplate.controller.dao;

import com.mateacademy.jdbctemplate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Long createUser(User user);
    Optional<User> findUserById(Long id);
    void updateUser(User user);
    void deleteUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
