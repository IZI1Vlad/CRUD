package ru.vpirogov.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId; // Список переменных используемых в классе
    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;

    // Гетеры и сетеры для получения данных о сотруднике
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {         this.dateOfEmployment = dateOfEmployment;
    }
    @Override    // Переопределение метода toString с возвратом в формате Id Имя Фамилия
    public String toString() {
        return String.format("Employee = [id='%d', firstName='%s', lastName='%s'.]", employeeId, firstName, lastName);
    }

}

