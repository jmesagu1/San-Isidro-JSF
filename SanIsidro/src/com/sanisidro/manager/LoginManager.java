package com.sanisidro.manager;

import com.sanisidro.Exception.AppExceptions;
import com.sanisidro.entity.UserLogin;
import com.sanisidro.service.GenericService;
import com.sanisidro.to.UserLoginTO;

public class LoginManager 
{
	public static LoginManager getInstance ()
	{
		return new LoginManager();
	}
	
	public boolean login (UserLoginTO userLoginTO) throws Exception
	{
		boolean valid = false;		
		UserLoginTO to = GenericService.find(new UserLogin(), userLoginTO, userLoginTO.getUsername());
		if (to != null)
		{
			if (userLoginTO.getPass().equals(to.getPass()))
			{
				valid = true;
			}
			else
			{
				throw new Exception(AppExceptions.INVALID_PASSWORD);
			}
		}
		else
		{
			throw new Exception(AppExceptions.INVALID_USERNAME);
		}					
				
		return valid;
	}
}
