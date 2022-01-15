package com.springBootThymeleaf.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBootThymeleaf.model.Employee;
import com.springBootThymeleaf.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// Fetch list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", this.employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		System.out.println("employee");
		return "add_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		this.employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployeeForm(@PathVariable(value="id") Long id, Model model) {
		Employee employee = this.employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") Long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
