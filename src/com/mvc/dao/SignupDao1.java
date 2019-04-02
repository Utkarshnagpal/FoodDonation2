package com.mvc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.bean.SignupBean;
import com.mvc.util.DBConnection;
public class SignupDao1
{
	public SignupDao1()
	{
		super();
	}
	public String registerUser1(SignupBean signupBean)
	{
		int count=0;
		String username = signupBean.getUsername();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String usernameDB = "";
		try
		{
			con = DBConnection.createConnection(); 
			statement = con.createStatement(); 
			resultSet = statement.executeQuery("select username from user"); 
			while(resultSet.next()) 
			{
				usernameDB = resultSet.getString("username");
				if(username.equals(usernameDB))
				{
					count++;
				}
			}
			if(count==0)
				return "SUCCESS";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; 
	}
		
}