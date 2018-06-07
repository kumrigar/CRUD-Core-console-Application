package com.CRUD.PersonImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.CRUD.Config.Config;
import com.CRUD.PersonsDao.PersonDAO;
import com.CRUD.model.Person;

public class PersonImpl implements PersonDAO{

	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	Connection connection;
	
	public PersonImpl() {
		connection = Config.createConnection();
	}
	
	//add user
	@Override
	public boolean insertPerson(Person person) {
		String query = "insert into Persons (id, name,email,password) values (?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getEmail());
			preparedStatement.setString(4, person.getPassword());

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("User is created successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	//update user
	@Override
	public void updatePerson(int id, Person person) {
		String sql = "UPDATE persons SET name=?, email=?,password=? WHERE id=" + id;
		int rowsUpdated = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.setString(3, person.getPassword());
			
			rowsUpdated = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsUpdated > 0) {
			System.out.println("An existing user was updated successfully!");
		}
	}

	//Delete User
	@Override
	public void deletePerson(int id) {
		try {
			String query = "delete from persons where id =" + id;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user deleted Successfully");
	}
	
	//GetByID
	@Override
	public Person readOnePerson(int id) {
		Person person = null;
		try {
			String sql = "Select * from Persons where id =" + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int personId = resultSet.getInt(1);
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				person=new Person();
				person.setId(personId);
				person.setName(name);
				person.setEmail(email);
				person.setPassword(password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
		//Display 
		@Override
		public List<Person> readAllPerson() {
			List<Person> personList = new ArrayList<>();
			try {
				String sql = "Select * from Persons";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					int personId = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String email = resultSet.getString(3);
					 String password = resultSet.getString(4);
					
					Person person = new Person();
					person.setId(personId);
					person.setName(name);
					person.setEmail(email);
					person.setPassword(password);
					
					
					personList.add(person);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return personList;
		}
		
		public Person readPersonByEmail(Person person) throws SQLException
		{
			ResultSet resultSet=null;
			String query="Select * from Persons where email=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, person.getEmail());
			resultSet = preparedStatement.executeQuery();

			Person person1=null;
			if(resultSet.next())
			{
					person1=new Person();
					person1.setId(resultSet.getInt(1));
					person1.setName(resultSet.getString(2));
					person1.setEmail(resultSet.getString(3));
					
					person1.setPassword(resultSet.getString(4));
				
			}
				return person1;
		}
	
	}

	

	

