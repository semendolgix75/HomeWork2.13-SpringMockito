package pro.sky.HomeWork18.lesson25.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18.lesson25.model.Employee;
import pro.sky.HomeWork18.lesson25.service.EmployeeService;
import java.util.Collection;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam Integer departmentNumber,
                                @RequestParam Integer salary) {

        return service.add(
                firstName,
                lastName,
                departmentNumber,
                salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }
    @GetMapping
    public Map<String,Employee> getAllEmployees() {
        return service.getAllEmployees();

   }
}
