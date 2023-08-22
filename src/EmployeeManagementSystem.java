// EmployeeManagementSystem class handles the management of employees, including adding, retrieving, updating, and deleting employees.
import java.util.List;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<Employee>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // Add an employee to the system.
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    // Retrieve the list of all employees.
    public List<Employee> getAllEmployees() {
        return this.getEmployees();
    }

    // Search for employees by name.
    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> employeesBySearchingName = new ArrayList<Employee>();
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                employeesBySearchingName.add(employee);
            }
        }
        return employeesBySearchingName;
    }

    // Search for employees by designation.
    public List<Employee> searchEmployeesByDesignation(String designation) {
        List<Employee> employeesBySearchingDesignation = new ArrayList<Employee>();
        for (Employee employee : this.employees) {
            if (employee.getDesignation().equals(designation)) {
                employeesBySearchingDesignation.add(employee);
            }
        }
        return employeesBySearchingDesignation;
    }

    // Get an employee by their unique ID.
    public Employee getEmployeeById(String id) {
        for (Employee employee : this.employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    // Update an existing employee's information.
    public void updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(updatedEmployee.getId())) {
                employee.setName(updatedEmployee.getName());
                employee.setAge(updatedEmployee.getAge());
                employee.setDesignation(updatedEmployee.getDesignation());
                employee.setSalary(updatedEmployee.getSalary());
                return;
            }
        }
    }

    // Delete an employee from the system by their ID.
    public void deleteEmployeeById(String id) {
        this.employees.removeIf(employee -> employee.getId().equals(id));
    }

    public int getTotalEmployeeCount() {
        return employees.size();
    }

    // Calculate and get the average salary of all employees.
    public double getAverageSalary() {
        if (employees.isEmpty()) {
            return 0.0;
        }

        double employeesSalary = 0;
        for (Employee employee : this.employees) {
            employeesSalary += employee.getSalary();
        }
        return employeesSalary / employees.size();
    }

    // Find the employee with the highest salary and return the Employee object.
    public Employee getHighestPaidEmployee() {
        if (employees.isEmpty()) {
            return null;
        }

        Employee highestPaidEmployee = employees.get(0);
        for (Employee employee : this.employees) {
            if (employee.getSalary() > highestPaidEmployee.getSalary()) {
                highestPaidEmployee = employee;
            }
        }
        return highestPaidEmployee;
    }
}
