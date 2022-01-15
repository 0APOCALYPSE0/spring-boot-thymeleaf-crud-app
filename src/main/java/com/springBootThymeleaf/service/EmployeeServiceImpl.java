package com.springBootThymeleaf.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springBootThymeleaf.repository.EmployeeRepo;
import com.springBootThymeleaf.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional = this.employeeRepo.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found with id: "+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.employeeRepo.deleteById(id);
	}
	
}
