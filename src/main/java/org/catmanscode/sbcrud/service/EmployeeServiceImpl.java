package org.catmanscode.sbcrud.service;

import java.util.List;

import org.catmanscode.sbcrud.exception.ResourceNotFoundException;
import org.catmanscode.sbcrud.model.Employee;
import org.catmanscode.sbcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {

		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(final long employeeId) {

		return this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));

	}

	@Override
	public Employee saveEmployee(final Employee employee) {

		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(final Employee employee, final long employeeId) {

		final Employee dbEmployee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));

		dbEmployee.setEmployeeName(employee.getEmployeeName());
		dbEmployee.setEmployeeAddress(employee.getEmployeeAddress());
		dbEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());

		this.employeeRepository.save(dbEmployee);

		return dbEmployee;
	}

	@Override
	public void deleteEmployee(final Long employeeId) {

		this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));

		this.employeeRepository.deleteById(employeeId);
	}

}
