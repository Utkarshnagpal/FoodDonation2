package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mvc.bean.NgoLoginBean;
import com.mvc.dao.NgoLoginDao;
public class ngoLoginServlet extends HttpServlet 
{
	public ngoLoginServlet()
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		NgoLoginBean ngologinBean = new NgoLoginBean(); 
		ngologinBean.setUsername(username); 
		ngologinBean.setPassword(password);
		
		NgoLoginDao ngologinDao = new NgoLoginDao();
		String userValidate = ngologinDao.authenticateUser(ngologinBean);
		
		if(userValidate.equals("SUCCESS")) 
		{
			request.setAttribute("username", username); 
			HttpSession session=request.getSession();  
	        session.setAttribute("username",username);
			request.getRequestDispatcher("/modal.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errMessage", userValidate); 
			request.getRequestDispatcher("/ngo.jsp").forward(request, response);
		}
	}
}