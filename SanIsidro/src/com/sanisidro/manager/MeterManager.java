package com.sanisidro.manager;

import java.util.Calendar;
import java.util.List;

import com.sanisidro.entity.Meter;
import com.sanisidro.service.GenericService;
import com.sanisidro.service.MeterService;
import com.sanisidro.to.MeterTO;

public class MeterManager {

	public List<MeterTO> searchMeters(String serie, double price, Calendar dateFrom, Calendar dateTo) 
			throws Exception  
	{
		return new MeterService().searchMeters(serie, price, dateFrom, dateTo);
	}

	public List<MeterTO> searchMetersByUser(String name, String lastName, long dni) 
			throws Exception  
	{
		return new MeterService().searchMetersByUser(name, lastName, dni);
	}

	public List<MeterTO> searchMetersByService(String farmName, double priceSuscription, long payNumber,
			Calendar dateFrom, Calendar dateTo, long zoneId, long serviceTypeId) 
			throws Exception  
	{
		return new MeterService().searchMetersByService(farmName, priceSuscription, payNumber, 
				dateFrom, dateTo, zoneId, serviceTypeId);
	}

	public MeterTO createMeter(MeterTO meter) {
		try {
			meter = GenericService.create(new Meter(), meter);
		} catch (Exception e) {
			meter.setId(-1);
			e.printStackTrace();
		}
		return meter;
	}
}