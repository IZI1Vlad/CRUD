package ru.vpirogov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vpirogov.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
