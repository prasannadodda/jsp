package com.capgemini.db;

import java.util.List;

import com.capgemini.business.Employee;

public interface EmployeeDAO {
	
	boolean addEmployee(Employee employee);
	boolean removeEmployee(Employee employee);
	boolean employee(Employee employee);
	Employee findEmployee(int id);
	List<Employee> getAllEmployee();
 
}
