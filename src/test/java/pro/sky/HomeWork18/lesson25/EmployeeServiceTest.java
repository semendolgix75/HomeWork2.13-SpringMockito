package pro.sky.HomeWork18.lesson25;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.junit.Assert.*;

import org.apache.coyote.BadRequestException;
import org.junit.Before;
import org.junit.Test;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.model.Employee;
import pro.sky.HomeWork18.lesson25.service.EmployeeService;
import pro.sky.HomeWork18.lesson25.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    String firstName = "Firstname";
    String lastName = "Lastname";
    Integer departmentNumber = 1;
    Integer salary = 10000000;

    @Before
    public void setUp() {
        employeeService = new EmployeeServiceImpl();


    }

    @Test
    public void shouldCheckAddEmployee() {
        employeeService.add(firstName, lastName, departmentNumber, salary);
        assertNotNull(employeeService.find(firstName, lastName));
    }

    @Test
    public void shouldCheckDeleteEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.remove(firstName, lastName);
        });
    }

    @Test
    public void shouldDeleteEmployee() {
        Employee actual = employeeService.add(firstName, lastName, departmentNumber, salary);
        Employee expected = employeeService.remove(firstName, lastName);
        assertEquals(actual, expected);
    }
    @Test
    public void shouldLowerCaseEmployee() {
        Employee employee=employeeService.add(firstName, lastName, departmentNumber, salary);
        String actual =capitalize(employee.getFirstName());;
        String expected = firstName;
        assertEquals(actual, expected);
        actual =capitalize(employee.getLastName());;
        expected = lastName;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindEmployee() {
        Employee employee = new Employee(firstName, lastName, departmentNumber, salary);
        employeeService.add(firstName, lastName, departmentNumber, salary);
        assertEquals(employee, employeeService.find(firstName, lastName));
    }
    @Test
    public void allEmployees() throws BadRequestException {
        Employee employee1 = employeeService.add("One", "One", 1, 100000);
        Employee employee2 = employeeService.add("Two", "Two", 2, 100000);
        Employee employee3 = employeeService.add("Three", "Three", 3, 100000);
        Employee employee4 = employeeService.add("Four", "Four", 4, 100000);
        Employee employee5 = employeeService.add("Six", "Six", 5, 100000);
        List<Employee> actual = new ArrayList<>(employeeService.allEmployees());
        List<Employee> expected = new ArrayList<>(List.of(employee1, employee2, employee3, employee4, employee5));
        assertEquals(actual, expected);
    }
}
