package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.UserType;
import com.sanisidro.service.GenericService;
import com.sanisidro.service.UserTypeService;
import com.sanisidro.to.UserTypeTO;

public class UserTypeManager {

	public UserTypeTO createUserType(UserTypeTO userType)
	{
		try 
		{
			return GenericService.create(new UserType(), userType);
		}
		catch (Exception e) {
			e.printStackTrace();
			userType.setId(-1);
			return userType;
		}
	}

	public boolean updateUserType(UserTypeTO userType) {
		try {
			GenericService.update(new UserType(), userType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<UserTypeTO> getAllUserTypes() {
		try {
			return new UserTypeService().getAllUserTypes();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}