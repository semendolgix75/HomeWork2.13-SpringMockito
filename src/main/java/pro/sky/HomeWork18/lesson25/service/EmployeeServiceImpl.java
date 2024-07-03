package pro.sky.HomeWork18.lesson25.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeEntryError;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

    }

    @PostConstruct
    private void init() {
        add("vasilyev", "Vasiliy", 1, 68000);
        add("Dmitriev", "Dmitriy", 2, 92000);
        add("Borisov", "Boris", 3, 90000);
        add("Vladimirov", "Vladimir", 4, 80000);
        add("Andreev", "Andrey", 5, 70200);
        add("Nikolaev", "Nikolay", 1, 85000);
        add("Ivanov", "Ivan", 2, 70000);
        add("Petrov", "Petr", 3, 68000);
        add("Sidorov", "Sidor", 4, 75000);
        add("Alekseev", "Aleksey", 5, 86000);
        add("Sergeev", "Sergey", 1, 82000);
        add("Putin", "Vladimir", 2, 75000);
        add("Haritonov", "Nikolay", 3, 69000);
        add("Davankov", "Vlad", 4, 71000);
        add("Slutskiy", "Leonid", 5, 76000);
    }

    @Override
    public Employee add(String firstName, String lastName, Integer departmentNumber, Integer salary) {
        checkTextData(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, departmentNumber, salary);
        if (employees.containsKey(getFullName(firstName,lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(getFullName(firstName,lastName), employee);
        return employee;
    }

    private void checkTextData(String firstName, String lastName) {
        if (!(isAlpha(firstName + lastName))) {
            throw new EmployeeEntryError("Ошибка ввода данных работника");
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName, departmentNumber, salary);
        if (employees.containsKey(getFullName(firstName,lastName))) {
            return employees.remove(getFullName(firstName,lastName));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (employees.containsKey(getFullName(firstName,lastName))) {
            return employees.get(getFullName(firstName,lastName));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {

        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public List<Employee> allEmployees() {
        return new ArrayList<>(employees.values());
    }
    public String getFullName(String firstName,String lastName){
        return firstName +"  "+ lastName;}
}


