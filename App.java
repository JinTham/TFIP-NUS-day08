import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException{
        String dirPath = "C:/Users/issuser/Desktop";
        String fileName = "data.txt";
        File newDir = new File(dirPath);
        if (!newDir.exists()){
            newDir.mkdir();
            System.out.println("New directory: "+dirPath+" is created");
        } else {
            System.out.println("Directory "+dirPath+" already created");
        }
        File newFile = new File(dirPath+File.separator+fileName);
        if (!newFile.exists()){
            newFile.mkdir();
            System.out.println("New file: "+fileName+" is created");
        } else {
            System.out.println("File "+fileName+" already created");
        }
        //list file under this directory
        // File[] fileList = newDir.listFiles();
        // for (File file : fileList){
        //     System.out.println("file "+file.getPath()+":"+file.getCanonicalFile());
        // }
        //Use FileOutputStream to write some integers to file 'data.txt'
        
        // FileOutputStream fileOS = new FileOutputStream(newFile);
        // String welcomeMessage = "Welcome to ISS TFIP programme!!!";
        // byte[] outputData = welcomeMessage.getBytes();
        // fileOS.write(outputData);
        // fileOS.flush();
        // fileOS.close();
        
        CSVWriter csvWriter = new CSVWriter();
        List<Employee> employees =  csvWriter.generateEmployees();
        csvWriter.writeToCSV(employees,newFile);

        //Read the file and print out
        CSVReader csvReader = new CSVReader();
        List<Employee> newEmployeeList = csvReader.readCSV(newFile);
    }   
}
