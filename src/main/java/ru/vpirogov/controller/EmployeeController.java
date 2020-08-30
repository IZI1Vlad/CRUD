package ru.vpirogov.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vpirogov.domain.Employee;
import ru.vpirogov.repo.EmployeeRepo;

import java.util.List;

@RestController   // Главный класс нашего проекта
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    @Autowired    // Конструктор
    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping  // Список Employee
    public List<Employee> list() {
        return employeeRepo.findAll();
    }

    @GetMapping("{id}") // Метод для получения одного сотр.
    public Employee getOne(@PathVariable("id") Employee employee) {
        return employee;
    }

    @PostMapping // Метод для создания одного сотр.
    public Employee create(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping("{id}") // Метод для обновления сотр.
    public Employee update(
            @PathVariable("id") Employee employeeFromDb,
            @RequestBody Employee employee) {
        BeanUtils.copyProperties(employee, employeeFromDb, "id");
        return employeeRepo.save(employeeFromDb);
    }

    @DeleteMapping("{id}") // Метод для удаления сотр.
    public void delete(@PathVariable("id") Employee employee) {
        employeeRepo.delete(employee);
    }
}

