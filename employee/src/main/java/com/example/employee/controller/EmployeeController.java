package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.employee.entity.Employee;
import com.example.employee.entity.MyEmployeeList;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.MyEmployeeListService;

import java.util.*;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private MyEmployeeListService myEmployeeService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/employee_register")
	public String employeeRegister() {
		return "employeeRegister";
	}
	
	@GetMapping("/available_employees")
	public ModelAndView getAllEmployee() {
		List<Employee>list=service.getAllEmployee();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("employeeList");
//		m.addObject("employee",list);
		return new ModelAndView("employeeList","employee",list);
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute Employee b) {
		service.save(b);
		return "redirect:/available_employees";
	}
	@GetMapping("/my_employees")
	public String getMyEmployees(Model model)
	{
		List<MyEmployeeList>list=myEmployeeService.getAllMyEmployees();
		model.addAttribute("employee",list);
		return "myEmployees";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Employee b=service.getEmployeeById(id);
		MyEmployeeList mb=new MyEmployeeList(b.getId(),b.getName(),b.getEmail(),b.getDepartment(),b.getSalary());
		myEmployeeService.saveMyEmployees(mb);
		return "redirect:/my_employees";
	}
	
	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id,Model model) {
		Employee b=service.getEmployeeById(id);
		model.addAttribute("employee",b);
		return "EmployeeEdit";
	}
	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_employees";
	}
	
}
