package com.mvc.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DB3Connection {
public static Connection createConnection()
{
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/foodapp";
	String username = "root"; 
	String password = "root";
	try 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		con = DriverManager.getConnection(url, username, password);
		System.out.println("Printing connection object "+con);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return con; 
	}
}
