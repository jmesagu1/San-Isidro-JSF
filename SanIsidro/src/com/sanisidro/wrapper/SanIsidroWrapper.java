package com.sanisidro.wrapper;

import java.util.List;

import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.manager.FareManager;
import com.sanisidro.manager.ServiceFareUserManager;
import com.sanisidro.manager.ServiceTypeManager;
import com.sanisidro.manager.UserTypeManager;
import com.sanisidro.manager.ZoneManager;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.to.ZoneTO;

public class SanIsidroWrapper {
	
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
	
	//public boolean login (UserLoginTO userLoginTO)
	
	public boolean updateUserType(UserTypeTO userType) {
		return new UserTypeManager().updateUserType(userType);
	}
	
	public List<UserTypeTO> getAllUserTypes() {
		return new UserTypeManager().getAllUserTypes();
	}
	
	public FareTO createFare(FareTO fare) {
		return new FareManager().create(fare);
	}
	
	public boolean updateFare(FareTO fare) {
		return new FareManager().update(fare);
	}
	
	public List<FareTO> getAllFares() {
		return new FareManager().getAllFares();
	}
	
	public ServiceFareUserTO createServiceFareUser(ServiceFareUserTO sfu) {
		return new ServiceFareUserManager().create(sfu);
	}

	public boolean updateServiceFareUser(ServiceFareUserTO sfu, ServiceFareUserPK oldPK) {
		return new ServiceFareUserManager().update(sfu, oldPK);
	}

	public List<ServiceFareUserTO> getAllServiceFareUser() {
		return new ServiceFareUserManager().getAllServiceFareUser();
	}
}