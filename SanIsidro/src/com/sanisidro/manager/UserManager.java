package com.sanisidro.manager;

import java.util.List;
import com.sanisidro.service.UserService;
import com.sanisidro.to.UserTO;

public class UserManager 
{
	public static UserManager getInstance ()
	{
		return new UserManager();
	}
	
	public UserTO createUser(UserTO userTO) throws Exception
	{		
		return UserService.createUser(userTO);
	}
	
	public UserTO updateUser(UserTO userTO) throws Exception
	{		
		return UserService.updateUser(userTO);
	}
	
	public List<UserTO> getAllCustomers (int first, int maxResutl)
	{
		return	UserService.getAllCustomers(first, maxResutl);
	}
	
	public static long coutUsers () throws Exception
	{
		return UserService.coutUsers();
	}
}
