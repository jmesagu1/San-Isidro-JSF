package com.sanisidro.wrapper;

import java.util.List;

import com.sanisidro.manager.ServiceTypeManager;
import com.sanisidro.manager.ZoneManager;
import com.sanisidro.to.ServiceTypeTO;
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
}