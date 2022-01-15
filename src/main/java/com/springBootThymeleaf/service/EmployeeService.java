package com.springBootThymeleaf.service;
import java.util.List;
import com.springBootThymeleaf.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	void deleteEmployeeById(Long id);
}
