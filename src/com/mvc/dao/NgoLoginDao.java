package com.mvc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.bean.NgoLoginBean;
import com.mvc.util.DB3Connection;
public class NgoLoginDao 
{
	public String authenticateUser(NgoLoginBean ngologinBean)
	{
		String username = ngologinBean.getUsername(); 
		String password = ngologinBean.getPassword();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String usernameDB = "";
		String passwordDB = "";
		try
		{
			con = DB3Connection.createConnection(); 
			statement = con.createStatement(); 
			resultSet = statement.executeQuery("select username,password from ngo_details"); 
			while(resultSet.next()) 
			{
				usernameDB = resultSet.getString("username"); 
				passwordDB = resultSet.getString("password");
				if(username.equals(usernameDB) && password.equals(passwordDB))
				{
					return "SUCCESS"; 
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; 
	}
}