package pro.sky.HomeWork18.lesson25.service;

import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {



    Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);


    Collection<Employee>  GetAllEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> AllEmployeesByDepartment();
}

