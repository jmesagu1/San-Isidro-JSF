package com.sanisidro.service;

import com.sanisidro.entity.User;
import com.sanisidro.entity.UserType;
import com.sanisidro.to.UserTO;
import com.sanisidro.to.UserTypeTO;

public class UserService {
	
	public static UserTO createUser(UserTO userTO)
	{
		try 
		{
			User user = GenericEntityTO.getEntity(userTO);			
			user.setType((UserType) GenericEntityTO.getEntity(userTO.getType()));
			user = GenericService.create(user);			
		}
		catch (Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
		}
		return userTO;
	}

}
