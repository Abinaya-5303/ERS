package com.example.employee.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	

	
	
		@Autowired
		private EmployeeRepository bRepo;
		
		public void save(Employee b) {
			bRepo.save(b);
		}
		
		public List<Employee> getAllEmployee(){
			return bRepo.findAll();
		}
		
		public Employee getEmployeeById(int id) {
			return bRepo.findById(id).get();
		}
		public void deleteById(int id) {
			bRepo.deleteById(id);
		}
	}


