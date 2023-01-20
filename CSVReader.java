import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static final String COMMA_DELIMITER = ",";

    public List<Employee> readCSV(File fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(fr);
        String line = "";
        String[] info;
        List<Employee> outputList = new ArrayList<>();
        while (null != (line = bufferReader.readLine())){
            if (line.startsWith("staffNo")){
                continue;
            }
            info = line.split(COMMA_DELIMITER);
            Employee emp  = new Employee(info[0], info[1], info[2], info[3], info[4], Integer.parseInt(info[5]));
            outputList.add(emp);
        }
        for (Employee e:outputList){
            System.out.println(e);
        }
        return outputList;
    }
}
