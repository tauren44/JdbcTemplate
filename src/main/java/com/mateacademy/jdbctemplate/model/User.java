package com.mateacademy.jdbctemplate.model;

import com.mateacademy.jdbctemplate.annotations.InjectRandomInit;
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

    @InjectRandomInit (min = 600, max = 5000)
    private Integer salary;
}
