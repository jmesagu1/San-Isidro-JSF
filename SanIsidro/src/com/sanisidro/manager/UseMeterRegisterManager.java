package com.sanisidro.manager;

import com.sanisidro.entity.UseMeterRegister;
import com.sanisidro.service.GenericService;
import com.sanisidro.to.UseMeterRegisterTO;

public class UseMeterRegisterManager {
	
	public UseMeterRegisterTO createUseMeterRegister(UseMeterRegisterTO to) {
		try 
		{
			to = GenericService.create(new UseMeterRegister(), to);
			return to;
		}
		catch (Exception e) {
			return null;
		}
	}
}
