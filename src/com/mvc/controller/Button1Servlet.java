package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.ButtonBean;
import com.mvc.dao.ButtonDao;
public class Button1Servlet extends HttpServlet 
{
	public Button1Servlet()
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String username=null;
		String location = request.getParameter("location");
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        username=(String)session.getAttribute("username");}
		
		
		ButtonBean buttonBean = new ButtonBean(); 
		buttonBean.setUsername(username); 
		buttonBean.setLocation(location);
		
		ButtonDao buttonDao = new ButtonDao();
		String userValidate = buttonDao.ButtonUser(buttonBean);
		
		
		if(userValidate.equals("SUCCESS")) 
		{
			request.setAttribute("username", username); 
			request.getRequestDispatcher("/modal2.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errMessage", userValidate); 
			request.getRequestDispatcher("/modal.jsp").forward(request, response);
		}
	}
}