package com.example.employee.service;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.MyEmployeeList;
import com.example.employee.repository.MyEmployeeRepository;

	

	@Service
	public class MyEmployeeListService {
		
		@Autowired
		private MyEmployeeRepository myemployee;
		
		public void saveMyEmployees(MyEmployeeList employee) {
			myemployee.save(employee);
		}
		
		public List<MyEmployeeList> getAllMyEmployees(){
			return myemployee.findAll();
		}
		
		public void deleteById(int id) {
			myemployee.deleteById(id);
		}
	}


