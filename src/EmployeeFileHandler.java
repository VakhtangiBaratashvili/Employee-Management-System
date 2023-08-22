import java.io.*;
import java.util.ArrayList;
import java.util.List;

// EmployeeFileHandler class contains methods to save and load employee data to/from a file in CSV format.
public class EmployeeFileHandler {

    // Save employee data to a file in CSV format.
    public void saveEmployeesToFile(List<Employee> employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employees) {
                String csvLine = String.format("%s,%s,%d,%s,%.2f%n",
                        employee.getId(), employee.getName(), employee.getAge(),
                        employee.getDesignation(), employee.getSalary());
                writer.write(csvLine);
            }
            System.out.println("Employee data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing employee data to file: " + e.getMessage());
        }
    }

    // Load employee data from a file in CSV format and return a list of Employee objects.
    public List<Employee> loadEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                if (employeeData.length == 5) {
                    String id = employeeData[0];
                    String name = employeeData[1];
                    int age = Integer.parseInt(employeeData[2]);
                    String designation = employeeData[3];
                    double salary = Double.parseDouble(employeeData[4]);
                    Employee employee = new Employee(id, name, age, designation, salary);
                    employees.add(employee);
                }
            }
            System.out.println("Employee data loaded from " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading employee data from file: " + e.getMessage());
        }

        return employees;
    }
}
