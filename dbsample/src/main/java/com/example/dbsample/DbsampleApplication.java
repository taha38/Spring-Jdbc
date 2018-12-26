package com.example.dbsample;

import com.example.repo.CustomerRepository;
import com.example.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.repo")
public class DbsampleApplication implements CommandLineRunner {


    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DbsampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       String custName = customerRepository.getCustomerName(1);

       System.out.println(custName);

        String prodName = productRepository.getProductName(1);

        System.out.println(prodName);

    }

}

