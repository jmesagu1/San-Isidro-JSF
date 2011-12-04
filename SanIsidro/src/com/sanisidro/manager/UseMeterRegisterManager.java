package com.sanisidro.manager;

import com.sanisidro.entity.UseMeterRegister;
import com.sanisidro.service.GenericService;
import com.sanisidro.to.UseMeterRegisterTO;

public class UseMeterRegisterManager {
	
	public UseMeterRegisterTO createUseMeterRegister(UseMeterRegisterTO to) {
		try 
		{
			UseMeterRegister entity = new UseMeterRegister();
			entity.setMeterId(to.getMeter().getId());
			entity.setDateRegister(to.getDateRegister());
			entity.setCountMeter(to.getCountMeter());
			entity = GenericService.create(entity);
			to.setId(entity.getId());
			return to;
		}
		catch (Exception e) {
			return null;
		}
	}
}
