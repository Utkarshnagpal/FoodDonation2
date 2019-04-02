package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.SignupBean;
import com.mvc.util.DB1Connection;
public class SignupDao 
{
	public String registerUser(SignupBean signupBean)
	{
		String name = signupBean.getName();
		String username = signupBean.getUsername();
		String email = signupBean.getEmail();
		String phone = signupBean.getPhone();
		String address = signupBean.getAddress();
		String password = signupBean.getPassword();
		String password1 = signupBean.getPassword1();
		String message = signupBean.getMessage();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DB1Connection.createConnection();
			String query = "insert into user values (?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, password);
			preparedStatement.setString(7, password1);
			preparedStatement.setString(8, message);
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