package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {
    JsonWriter jsonWriter = new JsonWriter();
    Zipper zipper = new Zipper();
    AuditLog auditLog = new AuditLog();

    public Path export(Map<String, Object> data, Path outDir, String fileName) {
        Path json = jsonWriter.write(data, outDir, fileName);
        Path zip = zipper.zip(json, outDir.resolve(fileName + ".zip"));
        auditLog.log("exported " + zip);
        return zip;
    }
}
