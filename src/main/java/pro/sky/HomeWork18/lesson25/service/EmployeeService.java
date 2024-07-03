package pro.sky.HomeWork18.lesson25.service;

import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, Integer departmentNumber, Integer salary);


    Employee remove(String firstName, String lastName);

    Collection<Employee> findAll();

    Employee find(String firstName, String lastName);

    List<Employee> allEmployees();
}

