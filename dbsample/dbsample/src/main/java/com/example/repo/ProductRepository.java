package com.example.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private static final String SELECT_SQL = "select NAME from PRODUCT where ID=?";
    @Autowired
    @Qualifier("productJdbcTemplate")
    JdbcTemplate productJdbcTemplate;

    public String getProductName(int id) {
        String name = productJdbcTemplate.queryForObject(SELECT_SQL, new Object[] {id}, String.class);

        return name;
    }
}
