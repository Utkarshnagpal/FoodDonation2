package com.mvc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;

import com.mvc.bean.RefreshBean;
import com.mvc.util.DB2Connection;

public class RefreshDao 
{
	public String authenticateUser(RefreshBean refreshBean)
	{
		String username = refreshBean.getUsername();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		String statusDB = "";
		String usernameDB="";
		
		try
		{
			con = DB2Connection.createConnection();
			ps = con.prepareStatement("select username,status from registration where username =?");
			ps.setString(1,username );
			resultSet = ps.executeQuery();
			while(resultSet.next()) 
			{
				statusDB = resultSet.getString("status"); 
				usernameDB=resultSet.getString("username");
				System.out.println("dao "+statusDB+" "+usernameDB);
				if(username.equals(usernameDB)&&statusDB.equals("accepted"))
				{
					System.out.println("accepted");
					return "accepted";
				}
				else if(username.equals(usernameDB)&&statusDB.equals("rejected"))
				{
					System.out.println("rejected");
					return "rejected";
				}
				else if(username.equals(usernameDB)&&statusDB.equals("pending"))
				{
					System.out.println("pending");
					return "pending";
				}
				else
				{
					System.out.println("blank");
					return "null";
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