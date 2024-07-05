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
    public Collection<Employee> getAllEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getAllEmployeesByDepartment(id);
    }
    @GetMapping("/{id}/salary/sum")
    public Integer getSumSalaryByDepartment(@PathVariable int id) {
        return departmentService.getSumSalaryByDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public Integer getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Integer getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartment(id);
    }
    @GetMapping("/max-salary")
    public Employee findWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> AllEmployeesByDepartment() {
        return departmentService.allEmployeesByDepartment();
    }


}