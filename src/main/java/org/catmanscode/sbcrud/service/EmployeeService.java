package org.catmanscode.sbcrud.service;

import java.util.List;

import org.catmanscode.sbcrud.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(long employeeId);

	Employee updateEmployee(Employee employee, long employeeId);

	void deleteEmployee(Long employeeId);

}
