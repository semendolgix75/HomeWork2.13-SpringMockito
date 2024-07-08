package pro.sky.HomeWork18.lesson25.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.lesson25.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeEntryError;
import pro.sky.HomeWork18.lesson25.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.lesson25.exception.EmployeeStorageIsFullException;
import pro.sky.HomeWork18.lesson25.model.Employee;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 16;
    private final Map<String, Employee> employees = new HashMap<>();


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

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
    @Override
    public Employee add(String firstName, String lastName, Integer departmentNumber, Integer salary) {

        checkTextData(firstName, lastName);

        String employeeKey = getEmployeeKey(firstName, lastName);

        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в хранилище");
        }
        if (employees.size() >= EMPLOYEES_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище заполнено!");
        }
        employees.put(employeeKey, new Employee(firstName, lastName, departmentNumber, salary));
        return employees.get(employeeKey);
    }


    private void checkTextData(String firstName, String lastName) {
        if (!(isAlpha(firstName + lastName))) {
            throw new EmployeeEntryError("Ошибка ввода данных работника");
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такого сатрудника нет в базе!");
        }
        return employees.remove(employeeKey);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такого сатрудника нет в базе!");
        }
        return employees.get(employeeKey);
    }

    @Override
    public Map<String,Employee> getAllEmployees() {

        return new HashMap<>(employees);
    }

    @Override
    public List<Employee> allEmployees() {
        return new ArrayList<>(employees.values());
    }
    @Override
    public String getFullName(String firstName,String lastName){
        return firstName +"  "+ lastName;}

}


