package com.mvc.bean;
public class SignupBean 
{
	private String name;
	private String username;
	private String email;
	private String phone;
	private String address;
	private String password;
	private String password1;
	private String message;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getPassword1() 
	{
		return password1;
	}
	public void setPassword1(String password1) 
	{
		this.password1 = password1;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
}