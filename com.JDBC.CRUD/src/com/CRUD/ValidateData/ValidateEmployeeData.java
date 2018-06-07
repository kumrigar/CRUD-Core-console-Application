package com.CRUD.ValidateData;


	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class ValidateEmployeeData 
	{
		public static boolean validateId(int id)
		{
			if(id>0 && id<1000000)
				return true;
			else
				return false;
		}
		public static boolean validateName(String name)
		{
			Pattern pattern=Pattern.compile("[^a-z]",Pattern.CASE_INSENSITIVE);
			Matcher matcher=pattern.matcher(name);
			
			if(matcher.find())
				return false;
			else
				return true;
		}
		public static boolean validateEmail(String email)
		{
			Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
			Matcher matcher=pattern.matcher(email);
			
			if(matcher.find())
				return true;
			else
				return false;
		}
	}


