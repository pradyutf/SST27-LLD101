package com.example.imports;

import java.io.*; 
import java.nio.file.*; 
import java.util.*;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter( NaiveCsvReader reader , ProfileService service ) {
        this.reader = reader;
        this.service = service;

    }
    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = reader.read(csvFile);

        int total = 0;

        for (String[] row : rows) {
            if (row.length != 3) throw new IllegalArgumentException("Expected 3 columns, got " + row.length);
            try{
                service.createProfile(row[0], row[1], row[2]);
                total++;
            } catch (Exception e){
                System.err.println("Failed to import row: " + Arrays.toString(row) + " due to " + e.getMessage());
            }
        }

        return total;
    }
    
}
