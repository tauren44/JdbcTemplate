package com.mateacademy.jdbctemplate.service.impl;

import com.mateacademy.jdbctemplate.model.User;
import com.mateacademy.jdbctemplate.repository.UserRepository;
import com.mateacademy.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long createUser(User user) {
        repository.save(user);
        return user.getId();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(repository.getOne(id));
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUserByReference(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
