package com.example.utils;

import com.opencsv.bean.ColumnPositionMappingStrategy;

public class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {

    private static final String[] HEADER = new String[]{"id",  "adress", "year"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}
