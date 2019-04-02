package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.AcceptBean;
import com.mvc.dao.AcceptDao;
@SuppressWarnings("serial")
public class AcceptServlet extends HttpServlet 
{
	public AcceptServlet()
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		 HttpSession session=request.getSession(false);  
	        if(session!=null){  
	        String name=(String)session.getAttribute("username");
		PrintWriter out=response.getWriter();
		int slNo = Integer.parseInt(request.getParameter("slNo"));
		AcceptBean acceptBean = new AcceptBean(); 
		acceptBean.setSlNo(slNo); 
		acceptBean.setName(name);
		
		AcceptDao acceptDao = new AcceptDao();
		String userValidate = acceptDao.authenticateUser(acceptBean);
		
		if(userValidate.equals("SUCCESS")) 
		{
			request.getRequestDispatcher("/modal2.jsp").forward(request, response);
		}
		else
		{
			out.println("<h1>Something went wrong!</h1>");
		}
	}
}}