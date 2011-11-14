package com.sanisidro.bean;

import com.sanisidro.to.UserLoginTO;
import com.sanisidro.wrapper.SanIsidroWrapper;


public class Login 
{
	private String username;
	private String password;
	private String message;
	
	public String login ()	
	{			
		UserLoginTO loginTO = new UserLoginTO();
		loginTO.setPass(password);
		loginTO.setUsername(username);
		String returnValue = "null";
		try 
		{
			 boolean valid = SanIsidroWrapper.getInstance().login(loginTO);
			if (valid)
			{
				message = "";
				returnValue  = "admin";
			}
			
		}
		catch (Exception e) 
		{		
			message = e.getMessage();
		}
		
 		return returnValue;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
