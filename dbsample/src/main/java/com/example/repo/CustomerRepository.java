package com.example.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@ComponentScan("com.example.config")
public class CustomerRepository {

    private static final String SELECT_SQL = "select NAME from CUSTOMER where ID=?";

    @Autowired
    @Qualifier("customerJdbcTemplate")
    JdbcTemplate customerJdbcTemplate;

    public String getCustomerName(int id) {
        String name = customerJdbcTemplate.queryForObject(SELECT_SQL, new Object[] {id}, String.class);

        return name;
    }
}
