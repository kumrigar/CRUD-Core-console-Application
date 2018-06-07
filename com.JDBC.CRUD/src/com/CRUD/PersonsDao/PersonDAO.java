package com.CRUD.PersonsDao;

import java.sql.SQLException;
import java.util.List;

import com.CRUD.model.Person;

public interface PersonDAO {

	public boolean insertPerson(Person person);
	public void updatePerson(int id,Person person);
	public void deletePerson(int id);
	public Person readOnePerson(int id);
	public Person readPersonByEmail(Person person) throws SQLException;
	
	List<Person> readAllPerson();
	
		
}
