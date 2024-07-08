package pro.sky.HomeWork18.lesson25.service;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.HomeWork18.lesson25.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeStorageIsFullException;
import pro.sky.HomeWork18.lesson25.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceImplTest {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private final int EMPLOYEES_STORAGE_SIZE = 16;
    @BeforeEach
    public void clear() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenSuchEmployeeIsAlreadyPresented() {
        //given
        employeeService.add("Namefirst", "Namelast", 1, 50000);

        //when
        //then
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Namefirst", "Namelast", 1, 50000));
    }

    @Test
    public void shouldCorrectlyAddEmployee() {
        //given
        Employee expected = new Employee("Namefirst", "Namelast", 1, 50000);

        //when
        Employee actual = employeeService.add(
                expected.getFirstName(),
                expected.getLastName(),
                expected.getDepartmentNumber(),
                expected.getSalary());

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowEmployeeIsFullExceptionWhenStorageIsFull() {
        //given
        String firstName = "Name";
        for (int i = 0; i < EMPLOYEES_STORAGE_SIZE; i++) {
            firstName += "a";

            employeeService.add(firstName, "Namelast", 1, 50000);
        }

        //when
        //then
        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add("Namefirst", "Namelast", 1, 50000));
    }

    @Test
    public void shouldTrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringRemoving() {
        //given
        //when
        //then
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()->employeeService.remove("Namefirst", "Namelast"));
    }
    @Test
    public void shouldTrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringFinding() {
        //given
        //when
        //then
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()->employeeService.find("Namefirst", "Namelast"));
    }

    @Test
    public void shouldFindEmployee() {
        //given
        Employee expected = employeeService.add("Namefirst", "Namelast", 1, 50000);


        //when
        Employee actual = employeeService.find(expected.getFirstName(), expected.getLastName());
        //then
        assertEquals(expected, actual);
    }

}
