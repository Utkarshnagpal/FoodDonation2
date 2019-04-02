package com.mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.SignupBean;
import com.mvc.dao.SignupDao;
import com.mvc.dao.SignupDao1;
@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet 
{
	public SignupServlet() 
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String message = request.getParameter("message");
		
		SignupBean signupBean = new SignupBean();
	
		signupBean.setName(name);
		signupBean.setUsername(username);
		signupBean.setEmail(email);
		signupBean.setPhone(phone); 
		signupBean.setAddress(address);
		signupBean.setPassword(password);
		signupBean.setPassword1(password1);
		signupBean.setMessage(message);
		
		
		SignupDao signupDao = new SignupDao();
		SignupDao1 signupDao1=new SignupDao1();
		
		String userRegistered1=signupDao1.registerUser1(signupBean);
		if(userRegistered1.equals("SUCCESS"))
		{
		
			String userRegistered = signupDao.registerUser(signupBean);
			if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
			{
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			else   
			{
				request.setAttribute("errMessage", userRegistered);
				request.getRequestDispatcher("/signup.jsp").include(request, response);
			}
		}
		else
		{
			out.println("<h1>Username should be unique</h1>");
			request.getRequestDispatcher("/signup.jsp").include(request, response);
		}
		
	}
}