abstract class Employee {
    String name;
    String role;
    abstract double calculateSalary();
    abstract void displayDetails();
}

class Manager extends Employee {
    double fixedSalary = 80000;

    Manager(String name) {
        this.name = name;
        this.role = "Manager";
    }

    double calculateSalary() {
        return fixedSalary;
    }

    void displayDetails() {
        System.out.println(name + " | " + role + " | Salary: " + calculateSalary());
    }
}

class Developer extends Employee {
    int hoursWorked = 160;
    double hourlyRate = 500;

    Developer(String name) {
        this.name = name;
        this.role = "Developer";
    }

    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    void displayDetails() {
        System.out.println(name + " | " + role + " | Salary: " + calculateSalary());
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee m = new Manager("Alice");
        Employee d = new Developer("Bob");

        m.displayDetails();
        d.displayDetails();
    }
}
