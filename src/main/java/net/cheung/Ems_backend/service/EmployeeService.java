package net.cheung.Ems_backend.service;

import java.util.List;
import net.cheung.Ems_backend.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto createEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long employeeId);

  List<EmployeeDto> getAllEmployees();

  EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

  // deleteEmployee
  void deleteEmployee(Long employeeId);
}
