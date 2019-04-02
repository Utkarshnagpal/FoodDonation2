package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.mvc.bean.AcceptBean;
import com.mvc.util.DBConnection;
public class AcceptDao 
{
	public String authenticateUser(AcceptBean acceptBean)
	{
		int slNo=acceptBean.getSlNo();
		String name=acceptBean.getName();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String usernameDB = "";
		String locationDB = "";
		int slNoDB=0;
		try
		{
			con = DBConnection.createConnection();
			String query = "update registration set status='accepted' where SlNo=?";
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setLong(1,slNo);
			int i= preparedStatement.executeUpdate();
			statement = con.createStatement(); 
			resultSet = statement.executeQuery("select slNo,username,location from registration"); 
			while(resultSet.next()) 
			{
				slNoDB = Integer.parseInt(resultSet.getString("slNo")); 
				if(slNoDB==slNo)
				{
					usernameDB=resultSet.getString("username");
					locationDB=resultSet.getString("location"); 
					
				}

			}
			String query1 = "insert into hotspot(username,location,ngo) values (?,?,?)"; 
			preparedStatement1 = con.prepareStatement(query1); //Making use of prepared statements here to insert bunch of data
			preparedStatement1.setString(1,usernameDB);
			preparedStatement1.setString(2,locationDB);
			preparedStatement1.setString(3,name);

			int j= preparedStatement1.executeUpdate();
			
			if ((i!=0)&&(j!=0))  //Just to ensure data has been inserted into the database
			return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}