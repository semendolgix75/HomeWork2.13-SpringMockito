package pro.sky.HomeWork18.lesson25.service;

import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {


    int getSumSalaryByDepartment(Integer departmentId);

    Employee findEmployeeWithMaxSalary(Integer departmentId);

    int getMaxSalaryByDepartment(Integer departmentId);

    int getMinSalaryByDepartment(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);


    Collection<Employee>  getAllEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> allEmployeesByDepartment();
}

