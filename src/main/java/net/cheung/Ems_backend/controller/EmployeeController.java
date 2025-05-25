package net.cheung.Ems_backend.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import net.cheung.Ems_backend.dto.EmployeeDto;
import net.cheung.Ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** EmployeeController */
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private EmployeeService employeeService;

  // Build Add Employee REST api
  @PostMapping
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
    EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  // Build Get Employee REST api
  @GetMapping("{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
    EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
    return new ResponseEntity<>(employeeDto, HttpStatus.OK);
  }

  // Build Get All Employees REST api
  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    List<EmployeeDto> employees = employeeService.getAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  // Build Update Employee REST api
  @PutMapping("{id}")
  public ResponseEntity<EmployeeDto> updateEmployee(
      @PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {

    EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
    return new ResponseEntity<>(employeeDto, HttpStatus.OK);
  }

  // Build Delete Employee REST api
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
    employeeService.deleteEmployee(employeeId);
    return new ResponseEntity<>("Employee deleted successfully!", HttpStatus.OK);
  }
}
