package pro.sky.HomeWork18.lesson25.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HomeWork18.lesson25.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    private final List<Employee> employeeList = new ArrayList<>() {{
        add(new Employee("Name1", "Lastname", 1, 60000));
        add(new Employee("Name2", "Lastname", 2, 61000));
        add(new Employee("Name3", "Lastname", 3, 62000));
        add(new Employee("Name4", "Lastname", 2, 63000));
        add(new Employee("Name5", "Lastname", 1, 64000));
    }};
    private final Map<String, Employee> employees = new HashMap<>();

    @BeforeEach
    public void initMap() {
        for (Employee employee : employeeList) {
            employees.put(employee.getFirstName() + employee.getLastName(), employee);
        }
    }

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldGetEmployees() {
        //given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> expectedEmployees = List.of(employeeList.get(0), employeeList.get(4));
        //when
        List<Employee> actualEmployees = departmentService.getAllEmployeesByDepartment(departmentId);
        //then
        org.assertj.core.api.Assertions
                .assertThat(actualEmployees)
                .containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }
    @Test
    public void shouldGetSalarySum() {
        //given
        Integer departmentId = 2;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        Integer expectedSalarySum =employeeList.get(1).getSalary()+ employeeList.get(3).getSalary();
        //when
        Integer actualSalarySum = departmentService.getSumSalaryByDepartment(departmentId);
        //then
        org.assertj.core.api.Assertions
                .assertThat(actualSalarySum)
                .isEqualTo(expectedSalarySum);
    }
    @Test
    public void shouldGetSalaryMin() {
        //given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        Integer expectedSalaryMin = employeeList.get(0).getSalary();
        //when
        Integer actualSalaryMin = departmentService.getEmployeeWithMinSalaryByDepartment(departmentId).getSalary();
        //then
        org.assertj.core.api.Assertions
                .assertThat(actualSalaryMin)
                .isEqualTo(expectedSalaryMin);
    }

    @Test
    public void shouldGetSalaryMax() {
        //given
        Integer departmentId = 2;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        Integer expectedSalaryMax = employeeList.get(3).getSalary();
        //when
        Integer actualSalaryMax = departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId).getSalary();
        //then
        org.assertj.core.api.Assertions
                .assertThat(actualSalaryMax)
                .isEqualTo(expectedSalaryMax);
    }

    @Test
    public void shouldGetGroupedByDepartmentEmployees() {
        //given
        Map<Integer,List<Employee>> expectedGroupedEmployees=new HashMap<>(){{
            put(1,List.of(employeeList.get(0),employeeList.get(4)));
            put(2,List.of(employeeList.get(1),employeeList.get(3)));
            put(3,List.of(employeeList.get(2)));
        }
        };
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        //when
        Map<Integer, List<Employee>> actualGroupedEmployees = departmentService.getGroupedByDepartmentEmployees();

        //then
        Assertions.assertThat(actualGroupedEmployees).isEqualTo(expectedGroupedEmployees);


    }
}