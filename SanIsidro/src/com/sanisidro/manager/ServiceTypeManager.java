package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.ServiceType;
import com.sanisidro.service.GenericService;
import com.sanisidro.service.ServiceTypeService;
import com.sanisidro.to.ServiceTypeTO;

public class ServiceTypeManager {	
	
	public ServiceTypeTO createServiceType(ServiceTypeTO serviceType)
	{
		try 
		{
			return GenericService.create(new ServiceType(), serviceType);
		}
		catch (Exception e) {
			e.printStackTrace();
			serviceType.setId(-1);
			return serviceType;
		}
	}
	
	public boolean updateServiceType(ServiceTypeTO serviceType) {
		try {
			GenericService.update(new ServiceType(), serviceType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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