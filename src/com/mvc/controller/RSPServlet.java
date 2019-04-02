package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.RefreshBean;
import com.mvc.dao.RefreshDao;
@SuppressWarnings("serial")
public class RSPServlet extends HttpServlet 
{
	public RSPServlet()
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String username=null;
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        username=(String)session.getAttribute("username"); 
        System.out.println(username);  
		
		RefreshBean refreshBean = new RefreshBean(); 
		refreshBean.setUsername(username);
		
		RefreshDao refreshDao = new RefreshDao();
		String userValidate = refreshDao.authenticateUser(refreshBean);
		
		if(userValidate.equals("accepted")) 
		{
			request.setAttribute("userName", username); 
			request.getRequestDispatcher("/RequestStatusAccepted.jsp").forward(request, response);
		}
		else if(userValidate.equals("rejected"))
		{
			request.setAttribute("username", username); 
			request.getRequestDispatcher("/RequestStatusRejected.jsp").forward(request, response);
		}
		else if(userValidate.equals("pending"))
		{
			request.setAttribute("username", username); 
			request.getRequestDispatcher("/RequestStatusPending.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/message1.jsp").include(request, response);
		}
		
	}
}
}