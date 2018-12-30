package com.example.repo;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@ComponentScan("com.example.config")
public class CustomerRepository {

    private static final String SELECT_SQL = "select * from CUSTOMER";

    @Autowired
    @Qualifier("customerJdbcTemplate")
    JdbcTemplate customerJdbcTemplate;

    public List<Customer> getAllCustomers() {
        List<Customer> custList = new ArrayList<>();
        List<Map<String, Object>> retList = customerJdbcTemplate.queryForList (SELECT_SQL);

        for (final Map row : retList) {

            custList.add(new Customer((String)row.get("id"), (String)row.get("name"), (String)row.get("birth_year"), (String)row.get("adress")));
        }

        for (Customer cust : custList){
            System.out.println(cust.toString());
        }
        return custList;
    }
}
