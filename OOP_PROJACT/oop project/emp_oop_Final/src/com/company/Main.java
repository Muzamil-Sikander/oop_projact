package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private double salary;

    public Employee(int id, String firstName, String lastName, String address, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", address=" + address + ", salary=" + salary + "]";
    }
}

class EmployeeManagementSystem {
    private final List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setSalary(newSalary);
                System.out.println("Employee salary updated: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("All Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class EmployeeManagementSystemDemo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        while (true) {
            System.out.print("----------------------------------------");
            System.out.println("\n" + ANSI_CYAN + "Employee Management System" + ANSI_RESET);
            System.out.println("----------------------------------------");
            System.out.println(ANSI_YELLOW + "1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit" + ANSI_RESET);
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Enter employee first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter employee last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter employee address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(id, firstName, lastName, address, salary);
                    system.addEmployee(employee);
                }
                case 2 -> {
                    System.out.print("Enter employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeEmployee(removeId);
                }
                case 3 -> {
                    System.out.print("Enter employee ID to update salary: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    system.updateEmployeeSalary(updateId, newSalary);
                }
                case 4 -> system.displayAllEmployees();
                case 5 -> {
                    System.out.println(ANSI_GREEN + "Exiting program..." + ANSI_RESET);
                    System.exit(0);
                }
                default -> System.out.println(ANSI_RED + "Invalid choice. Please try again." + ANSI_RESET);
            }
        }
    }
}