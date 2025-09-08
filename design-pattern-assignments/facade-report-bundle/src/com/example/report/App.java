package com.example.report;
import java.nio.file.*; import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        Path outDir = Path.of("out");
        String fileName = "report";
        
        ReportBundleFacade facade = new ReportBundleFacade();
        Path zip = facade.export(data, outDir, fileName);
        System.out.println("Wrote " + zip);

        // TODO: Replace the above with a single call to ReportBundleFacade.export(...)
    }
}
