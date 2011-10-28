package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.service.CRUDService;
import com.sanisidro.service.ZoneService;
import com.sanisidro.to.ZoneTO;

public class ZoneManager {
	
	public static final String DATA_SERVICE = "com.sanisidro.service.ZoneService";
	
	public ZoneTO createZone(ZoneTO zone)
	{
		try 
		{
			return (ZoneTO) new CRUDService().create(DATA_SERVICE, zone);
		}
		catch (Exception e) {
			e.printStackTrace();
			zone.setId(-1);
			return zone;
		}
	}
	
	public boolean updateZone(ZoneTO zone) {
		return new CRUDService().update(DATA_SERVICE, zone);
	}
	
	public List<ZoneTO> getAllZones() {
		try {
			return new ZoneService().getAllZones();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}