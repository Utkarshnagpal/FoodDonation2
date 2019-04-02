package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
public class RegisterDao 
{
	public String registerUser(RegisterBean registerBean)
	{
		String name = registerBean.getName();
		String location = registerBean.getLocation();
		String conno = registerBean.getConno();
		String purpose = registerBean.getPurpose();
		String username=registerBean.getUsername();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into registration(SlNo,name,location,contactNumber,purpose,status,username) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, location);
			preparedStatement.setString(3, conno);
			preparedStatement.setString(4, purpose);
			preparedStatement.setString(5, "pending");
			preparedStatement.setString(6, username);
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


