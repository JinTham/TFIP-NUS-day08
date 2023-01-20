import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionSortExample {

    public void example01() {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() * 100));

            // print out unsorted list
            System.out.print("Unsorted list: " + numbers);

            // Sort in ascending
            Collections.sort(numbers);

            // print out the sorted list
            System.out.println("Sorted list: " + numbers);

            // Sort in descending
            Collections.sort(numbers, Collections.reverseOrder());

            // print out the sorted list
            System.out.println("Sorted list (reverse): " + numbers);

            //Sort in descending
            //Collections.sort(numbers,Collections.reverseOrder());
            numbers.sort(Comparator.reverseOrder());

            // print out the sorted list
            System.out.println("Sorted list (reverse): " + numbers);
        }
    }
    
    public void example02(){
        Employee emp1 = new Employee("12345","Darren","SS","Lecturer","darren@gmail.com",20000);
        Employee emp2 = new Employee("23451","Dennis","SS","Lecturer","dennis@gmail.com",15000);
        Employee emp3 = new Employee("65625","Daniel","SS","Lecturer","daniel@gmail.com",25000);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        //Print out unsorted employees list
        System.out.println("employees before sorting: "+employees);
        //Do an ascending sort using Collections
        Collections.sort(employees);
        //Print out sorted employees list
        System.out.println(employees);
        //Sorting using Comparator and lambda
        employees.sort(Comparator.comparing(e->e.getSalary()));
        System.out.println("Sorted employees (salary): "+employees);

        List<Employee> filteredEmployees = employees.stream().filter(e->e.getFullName()
        .equalsIgnoreCase("dennis"))
        .collect(Collectors.toList());
        System.out.println("Filtered employees: "+filteredEmployees);
    }
}
