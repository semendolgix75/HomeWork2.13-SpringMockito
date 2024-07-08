package pro.sky.HomeWork18.lesson25.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.HomeWork18.lesson25.model.Employee;
import pro.sky.HomeWork18.lesson25.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)

    {
        this.departmentService = departmentService;
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable Integer id) {
        return departmentService.getAllEmployeesByDepartment(id);
    }
    @GetMapping("/{id}/salary/sum")
    public Integer getSumSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getSumSalaryByDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public Integer getMaxSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(id).getSalary();
    }

    @GetMapping("/{id}/salary/min")
    public Integer getMinSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(id).getSalary();
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees() {
        return departmentService.getGroupedByDepartmentEmployees();
    }


}