package com.mvc.bean;
public class RegisterBean 
{
	private String name;
	private String location;
	private String conno;
	private String purpose;
	private String username;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location= location;
	}
	public void setConno(String conno)
	{
		this.conno = conno;
	}
	public String getConno()
	{
		return conno;
	}
	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
}