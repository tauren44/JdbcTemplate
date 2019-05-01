package com.mateacademy.jdbctemplate.controller.dao.impl;

import com.mateacademy.jdbctemplate.controller.dao.UserDao;
import com.mateacademy.jdbctemplate.model.User;
import com.mateacademy.jdbctemplate.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String INSERT_SQL = "INSERT INTO users(name, age) VALUES (:name, :age)";
    private static final String SELECT_SQL = "SELECT * FROM users WHERE id=:id";
    private static final String SELECT_ALL_SQL = "SELECT * FROM users";
    private static final String UPDATE_SQL = "UPDATE users SET name=:name, age=:age WHERE id=:id";
    private static final String DELETE_SQL = "DELETE FROM users WHERE id=:id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired from ApplicationConfig.class
     */
    @Autowired()
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param user will be created in database
     * @return generated id for added user
     */
    @Override
    public Long createUser(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());
        params.addValue("age", user.getAge());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(INSERT_SQL, params, keyHolder);
        user.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return keyHolder.getKey().longValue();
    }

    /**
     * @param id target primary key for find
     * @return Optional of User
     */
    @Override
    public Optional<User> findUserById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_SQL, params, new UserRowMapper()));
    }

    /**
     * @param user target entity to update
     */
    @Override
    public void updateUser(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", user.getId());
        params.addValue("name", user.getName());
        params.addValue("age", user.getAge());
        jdbcTemplate.update(UPDATE_SQL, params);
    }

    /**
     * @param user target entity to delete from database
     */
    @Override
    public void deleteUser(User user) {
        deleteUser(user.getId());
    }

    /**
     * @param id target primary key to delete from database
     */
    @Override
    public void deleteUser(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(DELETE_SQL, params);
    }

    /**
     * @return all entities from the table
     */
    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new UserRowMapper());
    }
}
