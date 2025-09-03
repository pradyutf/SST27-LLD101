package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {
    // Sample legacy data from three sources
    List<EmployeeCSV> csvRows = List.of(
      new EmployeeCSV("501,Alice,Smith,alice.smith@globex.com"),
      new EmployeeCSV("502,Bob,Johnson,bob.johnson@globex.com")
    );

    List<EmployeeDB> dbRows = List.of(
      new EmployeeDB(601, "Carlos", "Martinez", "carlos.martinez@initech.com"),
      new EmployeeDB(602, "Priya", "Singh", "priya.singh@initech.com")
    );

    List<EmployeeLDAP> ldapRows = List.of(
      new EmployeeLDAP(Map.of("uid","701","givenName","Tom","sn","Brown","mail","tom.brown@umbrella.org")),
      new EmployeeLDAP(Map.of("uid","702","givenName","Linda","sn","White","mail","linda.white@umbrella.org"))
    );

    List<Employee> all = new ArrayList<>();


    for(EmployeeCSV employeeCSV : csvRows){
      EmployeeCSVAdapter adapterCSV = new EmployeeCSVAdapter();
      adapterCSV.ECSV = employeeCSV;
      all.add(adapterCSV);
    }
    for(EmployeeDB employeeDB : dbRows){
      EmployeeDBAdapter adapterDB = new EmployeeDBAdapter();
      adapterDB.EDB = employeeDB;
      all.add(adapterDB);
    }
    for(EmployeeLDAP employeeLDAP : ldapRows){
      EmployeeLDAPAdapter adapterLDAP = new EmployeeLDAPAdapter();
      adapterLDAP.ELDAP = employeeLDAP;
      all.add(adapterLDAP);
    }

    EmployeePrinter.print(all);
  }
}