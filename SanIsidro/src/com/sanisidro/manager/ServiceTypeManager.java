package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.service.CRUDService;
import com.sanisidro.service.ServiceTypeService;
import com.sanisidro.to.ServiceTypeTO;

public class ServiceTypeManager {
	
	public static final String DATA_SERVICE = "com.sanisidro.service.ServiceTypeService";
	
	public ServiceTypeTO createServiceType(ServiceTypeTO serviceType)
	{
		try 
		{
			return (ServiceTypeTO) new CRUDService().create(DATA_SERVICE, serviceType);
		}
		catch (Exception e) {
			e.printStackTrace();
			serviceType.setId(-1);
			return serviceType;
		}
	}
	
	public boolean updateServiceType(ServiceTypeTO serviceType) {
		return new CRUDService().update(DATA_SERVICE, serviceType);
	}
	
	public List<ServiceTypeTO> getAllServiceTypes() {
		try {
			return new ServiceTypeService().getAllServiceTypes();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}