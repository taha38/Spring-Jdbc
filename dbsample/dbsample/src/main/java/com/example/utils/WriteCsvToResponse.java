package com.example.utils;

import com.example.model.Customer;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;

public class WriteCsvToResponse {


    public static void writeCustomers( List<Customer> customers)  {

        try {
            File file =  new File("D://java//customers.csv") ;

            Writer writer =  new FileWriter(file);

            CustomMappingStrategy<Customer> mapStrategy
                    = new CustomMappingStrategy<>();

            mapStrategy.setType(Customer.class);


            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator('|')
                    .build();

            btcsv.write(customers);
            writer.close();

        } catch (CsvException ex) {

            System.out.println("Error mapping Bean to CSV"+ex.getMessage());
        }  catch (IOException ex) {

            System.out.println("Error mapping Bean to CSV"+ex.getMessage());
        }
    }

}
