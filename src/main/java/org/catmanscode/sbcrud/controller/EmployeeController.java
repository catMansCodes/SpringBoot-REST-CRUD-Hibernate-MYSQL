package org.catmanscode.sbcrud.controller;

import java.util.List;

import org.catmanscode.sbcrud.model.Employee;
import org.catmanscode.sbcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String welcome() {

		return "Welcome to Employee Rest CRUD Demo App";
	}

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		return new ResponseEntity<>(this.employeeService.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") final long id) {

		return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody final Employee employee) {

		return new ResponseEntity<>(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/update/{employeeId}")
	public ResponseEntity<Employee> editAndUpdateEmployee(@PathVariable("employeeId") final long id,
			@RequestBody final Employee employee) {

		return new ResponseEntity<>(this.employeeService.updateEmployee(employee, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") final long id) {

		this.employeeService.deleteEmployee(id);

		return new ResponseEntity<>("Employee Deleted successfully!!!", HttpStatus.OK);
	}
}
