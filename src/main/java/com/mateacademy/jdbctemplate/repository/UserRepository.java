package com.mateacademy.jdbctemplate.repository;

import com.mateacademy.jdbctemplate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
