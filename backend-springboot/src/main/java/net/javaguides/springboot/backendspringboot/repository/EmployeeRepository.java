package net.javaguides.springboot.backendspringboot.repository;

import net.javaguides.springboot.backendspringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}