package com.sanisidro.manager;

import com.sanisidro.entity.UseMeterRegister;
import com.sanisidro.service.GenericEntityTO;
import com.sanisidro.service.GenericService;
import com.sanisidro.to.UseMeterRegisterTO;

public class UseMeterRegisterManager {
	
	public UseMeterRegisterTO createUseMeterRegister(UseMeterRegisterTO to) {
		try 
		{
			//UseMeterRegister entity = GenericEntityTO.getEntity(new UseMeterRegister(), to);
			to = GenericService.create(new UseMeterRegister(), to);
			//to.setId(entity.getId());
			return to;
		}
		catch (Exception e) {
			return null;
		}
	}
}
