package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.ServiceStatus;
import com.sanisidro.service.GenericService;
import com.sanisidro.service.ServiceStatusService;
import com.sanisidro.to.ServiceStatusTO;

public class ServiceStatusManager {

	public ServiceStatusTO createServiceStatus(ServiceStatusTO serviceStatus)
	{
		try {
			return GenericService.create(new ServiceStatus(), serviceStatus);
		}
		catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setId(-1);
			return serviceStatus;
		}
	}

	public boolean updateServiceStatus(ServiceStatusTO serviceStatus) {
		try {
			GenericService.update(new ServiceStatus(), serviceStatus);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ServiceStatusTO> getAllServiceStatus() {
		try {
			return new ServiceStatusService().getAllServiceStatus();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
