package com.sanisidro.bean;

import com.sanisidro.to.UserLoginTO;
import com.sanisidro.wrapper.SanIsidroWrapper;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
			UserLoginTO to = SanIsidroWrapper.getInstance().login(loginTO);
			if (to != null)
			{
				message = "";
				saveUserSession(to);
				if (to.getAdmin())
				{
					returnValue  = "admin";
				}
				else
				{
					returnValue  = "user";
				}
				
			}
			
		}
		catch (Exception e) 
		{		
			message = e.getMessage();
		}
		
 		return returnValue;
	}
	
	
	public  void saveUserSession (UserLoginTO userTO)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", userTO);
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
