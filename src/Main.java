import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        EmployeeFileHandler fileHandler = new EmployeeFileHandler();

        // Load existing employee data from the file
        List<Employee> employees = fileHandler.loadEmployeesFromFile("employees.csv");
        ems.setEmployees(employees);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employees by Name");
            System.out.println("3. Search Employees by Designation");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Total Employees");
            System.out.println("7. Display Average Salary");
            System.out.println("8. Display Highest Paid Employee");
            System.out.println("9. Save Employee Data to File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer input

            switch (choice) {
                case 1 -> {
                    // Add an employee
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer input
                    System.out.print("Enter Employee Designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double input
                    Employee newEmployee = new Employee(id, name, age, designation, salary);
                    ems.addEmployee(newEmployee);
                    System.out.println("Employee added successfully!");
                }
                case 2 -> {
                    // Search employees by name
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    List<Employee> employeesByName = ems.searchEmployeesByName(searchName);
                    displayEmployees(employeesByName);
                }
                case 3 -> {
                    // Search employees by designation
                    System.out.print("Enter the designation to search: ");
                    String searchDesignation = scanner.nextLine();
                    List<Employee> employeesByDesignation = ems.searchEmployeesByDesignation(searchDesignation);
                    displayEmployees(employeesByDesignation);
                }
                case 4 -> {
                    // Update an employee
                    System.out.print("Enter the ID of the employee to update: ");
                    String updateId = scanner.nextLine();
                    Employee employeeToUpdate = ems.getEmployeeById(updateId);
                    if (employeeToUpdate != null) {
                        System.out.print("Enter updated Employee Name: ");
                        employeeToUpdate.setName(scanner.nextLine());
                        System.out.print("Enter updated Employee Age: ");
                        employeeToUpdate.setAge(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline character after reading the integer input
                        System.out.print("Enter updated Employee Designation: ");
                        employeeToUpdate.setDesignation(scanner.nextLine());
                        System.out.print("Enter updated Employee Salary: ");
                        employeeToUpdate.setSalary(scanner.nextDouble());
                        scanner.nextLine(); // Consume the newline character after reading the double input

                        System.out.println("Employee updated successfully!");
                    } else {
                        System.out.println("Employee with ID " + updateId + " not found.");
                    }
                }
                case 5 -> {
                    // Delete an employee
                    System.out.print("Enter the ID of the employee to delete: ");
                    String deleteId = scanner.nextLine();
                    ems.deleteEmployeeById(deleteId);
                    System.out.println("Employee deleted successfully!");
                }
                case 6 ->
                    // Display total employees
                        System.out.println("Total Employees: " + ems.getTotalEmployeeCount());
                case 7 ->
                    // Display average salary
                        System.out.println("Average Salary: " + ems.getAverageSalary());
                case 8 -> {
                    // Display highest paid employee
                    Employee highestPaidEmployee = ems.getHighestPaidEmployee();
                    if (highestPaidEmployee != null) {
                        System.out.println("Highest Paid Employee: " + highestPaidEmployee.getName()
                                + " (Salary: " + highestPaidEmployee.getSalary() + ")");
                    } else {
                        System.out.println("No employee found.");
                    }
                }
                case 9 ->
                    // Save employee data to file
                        fileHandler.saveEmployeesToFile(ems.getEmployees(), "employees.csv");
                case 0 -> {
                    // Exit the program
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Print a new line for readability
        }
    }

    // Helper method to display a list of employees
    private static void displayEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Age: " + employee.getAge());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("------------------------");
            }
        }
    }
}