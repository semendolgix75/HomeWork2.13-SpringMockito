package pro.sky.HomeWork18.lesson25.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18.lesson25.model.Employee;
import pro.sky.HomeWork18.lesson25.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> GetAllEmployeesByDepartment(@RequestParam int departmentId) {
        return departmentService.GetAllEmployeesByDepartment(departmentId);
    }
    @GetMapping("/allAll")
    public Map<Integer, List<Employee>> AllEmployeesByDepartment() {
        return departmentService.AllEmployeesByDepartment();
    }


}