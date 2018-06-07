package com.CRUD.PersonTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.CRUD.PersonImpl.PersonImpl;
import com.CRUD.model.Person;

public class PersonTest {
	
	PersonImpl personDAO;

	@Before
	public void setUp() throws Exception {
		personDAO = new PersonImpl();
		
	}

	@After
	public void tearDown() throws Exception {
		personDAO=null;	
	}
	
	//add
	@Test
	public void insertPersonTest() {
		Person person=new Person();
		person.setId(6);
		person.setName("Kunaal");
		person.setEmail("kumrigar@gmail.com");
		person.setPassword("pass@123");
		
		assertEquals(true,personDAO.insertPerson(person));
		
	}
	
	//delete
	@Ignore
	@Test
	public void deletePersonTest() {
		Person person=personDAO.readOnePerson(1);
		personDAO.deletePerson(1);
		boolean flag = false;
		if(1 != person.getId()) {
			flag = true;
			assertTrue(true);
		}
		else {
			flag = false;
			assertTrue(false);
		}
		
	}
	
	//update
	@Ignore
	@Test
	public void updatePersonTest() {
		Person person=new Person();		
		
		person.setName("John");
		person.setEmail("jon@gmail.com");
		person.setPassword("@123");
		
		personDAO.updatePerson(3,person);
		
		
		boolean flag1 = false;
		if(1 != person.getId()) {
			flag1 = true;
			assertTrue(true);
		}
		else {
			flag1 = false;
			assertTrue(false);
		}
		
		
	}
	
	@Ignore
	@Test
	public void test() {
		List<Person> list = personDAO.readAllPerson();
		
		for(Person person: list) {
			System.out.println("Id is: " + person.getId());
			System.out.println("Name is: " + person.getName());
			System.out.println("Email is: " + person.getEmail());
		
		}
		
		assertEquals(list.size()>=0,personDAO.readAllPerson());
	}	
	
	
	}


