package com.sanisidro.manager;

import com.sanisidro.to.UserLoginTO;

public class LoginManager 
{
	public static LoginManager getInstance ()
	{
		return new LoginManager();
	}
	
	public boolean login (UserLoginTO userLoginTO)
	{
		boolean valid = false;
		try
		{
			//GenericService.find(new UserLogin(), userLoginTO, pk);
		}
		catch (Exception e) 
		{
		
		}
		return valid;
	}
}
