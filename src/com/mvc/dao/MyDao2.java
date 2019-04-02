package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.MyBean2;
import com.mvc.util.DB5Connection;
public class MyDao2
{
	public String registerUser(MyBean2 myBean2)
	{
		String title = myBean2.getTitle();
		String message = myBean2.getMessage();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DB5Connection.createConnection();
			String query = "insert into blog values (?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1,title);
			preparedStatement.setString(2, message);
			int i= preparedStatement.executeUpdate();
			if (i!=0)  //Just to ensure data has been inserted into the database
			return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}