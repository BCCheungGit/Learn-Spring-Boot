package net.cheung.Ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cheung.Ems_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  

}
