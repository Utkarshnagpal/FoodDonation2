package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.ButtonBean;
import com.mvc.util.DBLOConnection;
public class ButtonDao 
{
	public String ButtonUser(ButtonBean buttonBean)
	{
		String location = buttonBean.getLocation();
		String username= buttonBean.getUsername();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBLOConnection.createConnection();
			String query = "insert into hotspot(username,location) values (?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, location);
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


