package com.CRUD.Config;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Config{
	
	public static Connection createConnection()
	{
		
		
		Connection connection=null;	
		
		try {
			//fis=new FileInputStream("db.properties");
			
			Class.forName("org.h2.Driver");
			
			connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/myDB","sa","");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		  
			
	return connection;
	}
}


