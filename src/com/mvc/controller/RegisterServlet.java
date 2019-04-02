package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
public class RegisterServlet extends HttpServlet 
{
	public RegisterServlet() 
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String username=null;
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String conno = request.getParameter("conno");
		String purpose = request.getParameter("purpose");
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        username=(String)session.getAttribute("username");}
		
		RegisterBean registerBean = new RegisterBean();
	
		registerBean.setName(name);
		registerBean.setLocation(location);
		registerBean.setConno(conno);
		registerBean.setPurpose(purpose); 
		registerBean.setUsername(username);
		
		
		RegisterDao registerDao = new RegisterDao();
		
		String userRegistered = registerDao.registerUser(registerBean);
		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/RequestStatusPending.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/registration.jsp").include(request, response);
		}
	}
}