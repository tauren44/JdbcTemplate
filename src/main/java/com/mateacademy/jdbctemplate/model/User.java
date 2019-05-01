package com.mateacademy.jdbctemplate.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"id"})
public class User {
    private Long id;
    private String name;
    private Integer age;
}
