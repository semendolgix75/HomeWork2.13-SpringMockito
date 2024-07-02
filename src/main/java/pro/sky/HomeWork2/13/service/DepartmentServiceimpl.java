package pro.sky.HomeWork18.lesson25.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceimpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }


    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Collection<Employee> GetAllEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentNumber() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> AllEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartmentNumber));
    }
}

