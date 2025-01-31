package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		private String email;
		private String department;
		private String salary;
		public Employee(int id, String name, String email, String department,String salary) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.department = department;
			this.salary= salary;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department= department;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary= salary;
		}
		
	}


