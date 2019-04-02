package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mvc.bean.MyBean1;
import com.mvc.daointerface.MyInterface1;
import com.mvc.util.DBConnection;

public class MyDao1 implements MyInterface1{
  Connection con=DBConnection.createConnection();
  
	public ArrayList<MyBean1> displayAll(String location) {
		ArrayList<MyBean1> a1=new ArrayList<MyBean1>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from registration where status='pending'");
			
			
				while (rs.next()) {
					if(rs.getString(3).equals(location)){
					MyBean1 sb=new MyBean1();
					sb.setSlNo(Integer.parseInt(rs.getString(1)));
					sb.setName(rs.getString(2));
					sb.setLocation(location);
					sb.setPurpose(rs.getString(5));
					a1.add(sb);}
				}
		}
				catch (SQLException e) {
					System.out.println("error in display all");
					e.printStackTrace();
				}
		
				return a1;
		}
			

	@Override
	public int autoGenerateSid() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String insert1(MyBean1 s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update1(MyBean1 name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<MyBean1> displayAll() {
		// TODO Auto-generated method stub
		return null;
	}

}