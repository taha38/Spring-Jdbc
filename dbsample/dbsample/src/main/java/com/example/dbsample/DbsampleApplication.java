package com.example.dbsample;

import com.example.model.Customer;
import com.example.repo.CustomerRepository;
import com.example.repo.ProductRepository;
import com.example.utils.WriteCsvToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan({"com.example.repo","com.example.utils"})
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
       List<Customer> custList = customerRepository.getAllCustomers();

        WriteCsvToResponse.writeCustomers(custList);

       // String prodName = productRepository.getProductName(1);
        //System.out.println(prodName);

    }

}

