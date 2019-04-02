package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.MyBean2;
import com.mvc.dao.MyDao2;
@SuppressWarnings("serial")
public class MyServlet2 extends HttpServlet 
{
	public MyServlet2() 
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		
		MyBean2 myBean2 = new MyBean2();
	
		myBean2.setTitle(title);
		myBean2.setMessage(message);
		
		
		MyDao2 myDao2 = new MyDao2();
		
			String userRegistered = myDao2.registerUser(myBean2);
			if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
			{
				out.println("<h1>Your blog has successfully saved</h1>");
			}
			else   
			{
				out.println("<h1>Sorry! something Wrong!</h1>");
			}
		}
		
	}