package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @Qualifier("customerDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("productDataSource")
    @ConfigurationProperties(prefix="product.datasource")
    DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("customerJdbcTemplate")
    JdbcTemplate customerJdbcTemplate(@Qualifier("customerDataSource")DataSource customerDataSource) {
        return new JdbcTemplate(customerDataSource);
    }

    @Bean
    @Qualifier("productJdbcTemplate")
    JdbcTemplate productJdbcTemplate(@Qualifier("productDataSource")DataSource productDataSource) {
        return new JdbcTemplate(productDataSource);
    }
}
