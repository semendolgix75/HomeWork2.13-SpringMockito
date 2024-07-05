package pro.sky.HomeWork18.lesson25.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService mockEmployeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    public static final String FIRST_NAME1 = "Ivan";
    public static final String FIRST_NAME2 = "Petr";
    public static final String FIRST_NAME3 = "Aleksey";
    public static final String FIRST_NAME4 = "Dmitriy";
    public static final String FIRST_NAME5 = "Leonid";
    public static final String LAST_NAME1 = "Ivanov";
    public static final String LAST_NAME2 = "Petrov";

    public static final int DEPARTMENT1 = 1;
    public static final int DEPARTMENT2 = 2;
    public static final int DEPARTMENT3 = 3;
    public static final int MAX_SALARY = 60000;
    public static final int MIN_SALARY = 45000;
    public static final Employee EMPLOYEE1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, MAX_SALARY);
    public static final Employee EMPLOYEE2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, MIN_SALARY);
    public static final Employee EMPLOYEE3 = new Employee(FIRST_NAME3, LAST_NAME2, DEPARTMENT1, MIN_SALARY);
    public static final Employee EMPLOYEE4 = new Employee(FIRST_NAME4, LAST_NAME2, DEPARTMENT2, MAX_SALARY);
    public static final Employee EMPLOYEE5 = new Employee(FIRST_NAME5, LAST_NAME2, DEPARTMENT3, MIN_SALARY);

    public static final List<Employee> EMPLOYEES = new ArrayList<>(List.of(
            EMPLOYEE1, EMPLOYEE2, EMPLOYEE3, EMPLOYEE4, EMPLOYEE5
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT1 = new ArrayList<>(List.of(
            EMPLOYEE1, EMPLOYEE3
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT2 = new ArrayList<>(List.of(
            EMPLOYEE2, EMPLOYEE4
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT3 = new ArrayList<>(List.of(
            EMPLOYEE5
    ));
    public static final Map<Integer, List<Employee>> EMPLOYEES_GROUPING_OF_DEPTARTMENT = new HashMap<>(Map.of(
            1, EMPLOYEES_BY_DEPARTMENT1,
            2, EMPLOYEES_BY_DEPARTMENT2,
            3, EMPLOYEES_BY_DEPARTMENT3
    ));

    ;

    @Test
    void shouldEmployeeMaxSalaryByDepartment() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY, departmentService.getMaxSalaryByDepartment(1));
    }

    @Test
    void ShouldEmployeeMinSalaryWithDepartment() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY, departmentService.getMinSalaryByDepartment(1));
    }

    @Test
    void ShouldEmployeeMaxSalaryDepartmentNoSuchElement() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertThrows(NoSuchElementException.class, () ->
                departmentService.findEmployeeWithMaxSalary(9));

    }
    @Test
    void ShouldEmployeeMinSalaryDepartmentNoSuchElement() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertThrows(NoSuchElementException.class, () ->
                departmentService.findEmployeeWithMinSalary(99));

    }
    @Test
    void ShouldEmployeeSumSalaryWithDepartment() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY + MIN_SALARY, departmentService.getSumSalaryByDepartment(2));
    }
    @Test
    void ShouldEmployeeSumSalaryDepartmentNoSuchElement() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        assertEquals(0,departmentService.getSumSalaryByDepartment(99));
    }
    @Test
    void ShouldAllEmployeesByDepartment() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);

        assertIterableEquals(EMPLOYEES_BY_DEPARTMENT2, departmentService.getAllEmployeesByDepartment(2));
    }
    @Test
    void  ShouldAllEmployeesDepartmentNoSuchElement() {
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        List<Employee> emptyList = new ArrayList<>();
        assertEquals(emptyList, departmentService.getAllEmployeesByDepartment(1000));
    }
    @Test
    void ShouldAllEmployeesGroupOfDepartment(){
        when(mockEmployeeService.findAll())
                .thenReturn(EMPLOYEES);
        Map<Integer, List<Employee>> actual = departmentService.allEmployeesByDepartment();
        assertEquals(EMPLOYEES_GROUPING_OF_DEPTARTMENT, actual);

    }
}