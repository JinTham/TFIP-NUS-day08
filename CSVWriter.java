import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";


    public List<Employee> generateEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        //Create some employees
        Employee emp1 = new Employee("12345","Darren","SS","Lecturer","darren@gmail.com",20000);
        Employee emp2 = new Employee("23451","Dennis","SS","Lecturer","dennis@gmail.com",15000);
        Employee emp3 = new Employee("65625","Daniel","SS","Lecturer","daniel@gmail.com",25000);
        //Add the employess to the list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        return employees;
    }
    
    public void writeToCSV(List<Employee> employees, File fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        //Write File_HEADER to CSV
        fw.append(FILE_HEADER.toString());
        fw.append(NEWLINE_SEPARATOR);
        //Read records row by row and write it using fw.append
        for (Employee emp : employees){
            fw.append(emp.getStaffNo());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getFullName());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getDepartment());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getRole());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getEmailAddress());
            fw.append(COMMA_DELIMITER);
            fw.append(String.valueOf(emp.getSalary()));
            fw.append(NEWLINE_SEPARATOR);
        }
        fw.flush();
        fw.close();
    }
}
