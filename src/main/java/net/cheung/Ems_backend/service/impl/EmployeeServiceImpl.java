package net.cheung.Ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.cheung.Ems_backend.dto.EmployeeDto;
import net.cheung.Ems_backend.entity.Employee;
import net.cheung.Ems_backend.exception.ResourceNotFoundException;
import net.cheung.Ems_backend.mapper.EmployeeMapper;
import net.cheung.Ems_backend.repository.EmployeeRepository;
import net.cheung.Ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto createEmployee(EmployeeDto employeeDto) {

    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee savedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(savedEmployee);
  }

  @Override
  public EmployeeDto getEmployeeById(Long employeeId) {
    Employee employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Employee does not exist with id: " + employeeId));
    return EmployeeMapper.mapToEmployeeDto(employee);
  }
}
