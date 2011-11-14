package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.service.CRUDService;
import com.sanisidro.service.ServiceFareUserService;
import com.sanisidro.to.ServiceFareUserTO;

public class ServiceFareUserManager {

	public static final String DATA_SERVICE = "com.sanisidro.service.ServiceFareUserService";

	public ServiceFareUserTO create(ServiceFareUserTO sfu) {
		try 
		{
			return (ServiceFareUserTO) new CRUDService().create(DATA_SERVICE, sfu);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(ServiceFareUserTO sfu, ServiceFareUserPK oldPk) {
		return new CRUDService().update(DATA_SERVICE, new Object[]{sfu, oldPk});
	}

	public ServiceFareUserTO getDetails(ServiceFareUserPK pk) {
		try 
		{
			return (ServiceFareUserTO) new CRUDService().get(DATA_SERVICE, pk);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ServiceFareUserTO> getAllServiceFareUser() {
		try {
			return new ServiceFareUserService().getAllServiceFareUser();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}