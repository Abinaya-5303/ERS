package com.example.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.service.MyEmployeeListService;

@Controller
public class MyEmployeeListController {
	
	
		
		@Autowired
		private MyEmployeeListService service;
		
		@RequestMapping("/deleteMyList/{id}")
		public String deleteMyList(@PathVariable("id") int id) {
			service.deleteById(id);
			return "redirect:/my_employees";
		}
	}


