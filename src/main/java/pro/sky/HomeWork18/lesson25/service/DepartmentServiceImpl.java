package pro.sky.HomeWork18.lesson25.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override


    public Integer getSumSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentNumber().equals(departmentId))
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();

    }


    @Override
    public Employee getEmployeeWithMaxSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public Employee getEmployeeWithMinSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber() .equals( departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees() {
        return employeeService.getAllEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentNumber));
    }
}

