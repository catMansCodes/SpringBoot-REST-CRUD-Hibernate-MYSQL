package org.catmanscode.sbcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long id;

	@Column(name = "employee_name", nullable = false)
	private String employeeName;

	@Column(name = "employee_address", nullable = false)
	private String employeeAddress;

	@Column(name = "employee_department", nullable = false)
	private String employeeDepartment;

}
