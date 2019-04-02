package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RejectBean;
import com.mvc.dao.RejectDao;
@SuppressWarnings("serial")
public class RejectServlet extends HttpServlet 
{
	public RejectServlet()
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		PrintWriter out=response.getWriter();
		int slNo = Integer.parseInt(request.getParameter("slNo"));
		RejectBean rejectBean = new RejectBean(); 
		rejectBean.setSlNo(slNo); 
		
		RejectDao rejectDao = new RejectDao();
		String userValidate = rejectDao.authenticateUser(rejectBean);
		
		if(userValidate.equals("SUCCESS")) 
		{
			request.getRequestDispatcher("/modal3.jsp").forward(request, response);
		}
		else
		{
			out.println("<h1>Something Wrong</h1>");
		}
	}
}