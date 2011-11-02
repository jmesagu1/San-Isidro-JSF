package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.service.CRUDService;
import com.sanisidro.service.UserTypeService;
import com.sanisidro.to.UserTypeTO;

public class UserTypeManager {

	public static final String DATA_SERVICE = "com.sanisidro.service.UserTypeService";

	public UserTypeTO createUserType(UserTypeTO userType)
	{
		try 
		{
			return (UserTypeTO) new CRUDService().create(DATA_SERVICE, userType);
		}
		catch (Exception e) {
			e.printStackTrace();
			userType.setId(-1);
			return userType;
		}
	}

	public boolean updateUserType(UserTypeTO userType) {
		return new CRUDService().update(DATA_SERVICE, userType);
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