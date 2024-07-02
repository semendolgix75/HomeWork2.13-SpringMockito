package pro.sky.HomeWork18.lesson25.model;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final Integer departmentNumber;
    private final Integer salary;


    public Employee(String firstName, String lastName, Integer departmentNumber, Integer salary) {
        this.firstName = capitalize(firstName.toLowerCase());;
        this.lastName = capitalize(lastName.toLowerCase());
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public Integer getSalary() {
        return salary;
    }
    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(departmentNumber, employee.departmentNumber) && Objects.equals(salary, employee.salary);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentNumber=" + departmentNumber +
                ", salary=" + salary +
                '}';
    }
}
