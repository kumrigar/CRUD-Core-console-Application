package com.CRUD.model;

import com.CRUD.ValidateData.ValidateEmployeeData;

public class Person {
		
		private int id;
		private String name;
		private String email;
		private String password;
		
		public Person (int id, String name, String email, String password)
		{
			this.id = id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
		}

		public Person() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) 
			{
				boolean status=ValidateEmployeeData.validateId(id);
				if(status)
					this.id = id;
				else
					System.out.println("Id is out of range");
			}
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			boolean status=ValidateEmployeeData.validateName(name);
			if(status)
				this.name = name;
			else
				System.out.println("Name can not contain special characters or digits");
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			boolean status=ValidateEmployeeData.validateEmail(email);
			if(status)
				this.email = email;
			else
				System.out.println("Incorrect email!! Please enter correct email");
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}


