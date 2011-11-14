package com.sanisidro.wrapper;

import java.util.List;

import com.sanisidro.manager.LoginManager;
import com.sanisidro.manager.ServiceTypeManager;
import com.sanisidro.manager.UserTypeManager;
import com.sanisidro.manager.ZoneManager;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserLoginTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.to.ZoneTO;

public class SanIsidroWrapper {
	
	
	public static SanIsidroWrapper getInstance ()
	{
		return new SanIsidroWrapper();		
	}
	
	public ZoneTO createZone(ZoneTO zone) {
		return new ZoneManager().createZone(zone);
	}
	
	public boolean updateZone(ZoneTO zone) {
		return new ZoneManager().updateZone(zone);
	}
	
	public List<ZoneTO> getAllZones() {
		return new ZoneManager().getAllZones();
	}

	public ServiceTypeTO createServiceType(ServiceTypeTO serviceType) {
		return new ServiceTypeManager().createServiceType(serviceType);
	}
	
	public boolean updateServiceType(ServiceTypeTO serviceType) {
		return new ServiceTypeManager().updateServiceType(serviceType);
	}
	
	public List<ServiceTypeTO> getAllServiceTypes() {
		return new ServiceTypeManager().getAllServiceTypes();
	}
	
	public UserTypeTO createUserType(UserTypeTO userType) {
		return new UserTypeManager().createUserType(userType);
	}
	
	public boolean login (UserLoginTO userLoginTO) throws Exception
	{
		return LoginManager.getInstance().login(userLoginTO);
	}
	
	public boolean updateUserType(UserTypeTO userType) {
		return new UserTypeManager().updateUserType(userType);
	}
	
	public List<UserTypeTO> getAllUserTypes() {
		return new UserTypeManager().getAllUserTypes();
	}
}