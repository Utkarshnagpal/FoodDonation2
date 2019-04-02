package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mvc.bean.MyBean3;
import com.mvc.daointerface.MyInterface;
import com.mvc.util.DBConnection;

public class MyDao3 implements MyInterface{
  Connection con=DBConnection.createConnection();
  
	public ArrayList<MyBean3> displayAll() {
		ArrayList<MyBean3> a1=new ArrayList<MyBean3>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from blog");
			
			
			while (rs.next()) {
				MyBean3 sb=new MyBean3();
				sb.setTitle(rs.getString(1));
				sb.setMessage(rs.getString(2));
				a1.add(sb);
			}
		} catch (SQLException e) {
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
	public String insert(MyBean3 s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(MyBean3 name) {
		// TODO Auto-generated method stub
		return false;
	}

}