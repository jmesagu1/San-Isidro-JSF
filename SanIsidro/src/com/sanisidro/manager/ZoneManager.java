package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.Zone;
import com.sanisidro.service.GenericService;
import com.sanisidro.service.ZoneService;
import com.sanisidro.to.ZoneTO;

public class ZoneManager {
	
	public ZoneTO createZone(ZoneTO zone)
	{
		try 
		{
			return GenericService.create(new Zone(), zone);
		}
		catch (Exception e) {
			e.printStackTrace();
			zone.setId(-1);
			return zone;
		}
	}
	
	public boolean updateZone(ZoneTO zone) {
		try {
			GenericService.update(new Zone(), zone);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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