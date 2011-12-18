package com.sanisidro.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sanisidro.service.ServicesService;
import com.sanisidro.service.UseChargeRegisterService;
import com.sanisidro.service.UseMeterRegisterService;
import com.sanisidro.to.MeterTO;
import com.sanisidro.to.ServiceTO;
import com.sanisidro.to.UseChargeRegisterTO;
import com.sanisidro.to.UseMeterRegisterTO;

public class UseChargeRegisterManager {

	public boolean registerUseCharges()
    {
		boolean result;
		try 
		{
	        List<UseChargeRegisterTO> ucrs = new ArrayList<UseChargeRegisterTO>();
	        List<ServiceTO> services = new ServicesService().getActiveServices();
	        UseMeterRegisterService usageService = new UseMeterRegisterService();
	        for (ServiceTO service : services)
	        {
	            List<UseMeterRegisterTO> umrs = usageService.getUseMeterRegisters(service);
	            if (umrs.size() > 0)
	            {
	            	ucrs.add(calculateUseChargeRegister(umrs, service));
	            }
	            else
	            {
	                ucrs.add(getNoMeterPriceFare(service));
	            }
	        }
	        result = new UseChargeRegisterService().createMeterCharges(ucrs);
		}
		catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
    }
	
	public UseChargeRegisterTO calculateUseChargeRegister(List<UseMeterRegisterTO> umrs, ServiceTO service) {
		MeterTO meter = umrs.get(0).getMeter();
        double price = meter.getService().getFare().getPrice();
        double addMetersPrice = meter.getAddMeterFare().getPrice();
        if (umrs.size() == 1)
        {
            if (umrs.get(0).getCountMeter() > meter.getMaxMeters())
            {
                price += (umrs.get(0).getCountMeter() - meter.getMaxMeters()) * addMetersPrice;
            }
        }
        else
        {
            double used = umrs.get(0).getCountMeter() - umrs.get(1).getCountMeter();
            if (used > meter.getMaxMeters())
            {
                price += (used - meter.getMaxMeters()) * addMetersPrice;
            }
        }
        UseChargeRegisterTO register = new UseChargeRegisterTO();
        register.setAddMeterPrice(addMetersPrice);
        register.setChargeDate(Calendar.getInstance());
        register.setMaxMeters(meter.getMaxMeters());
        register.setPayStatus(false);
        register.setPrice(price);
        register.setService(service);
        return register;
	}
	
	public UseChargeRegisterTO getNoMeterPriceFare(ServiceTO  service)
    {
        double price = service.getFare().getPrice();
        UseChargeRegisterTO register = new UseChargeRegisterTO();
        register.setAddMeterPrice(0);
        register.setChargeDate(Calendar.getInstance());
        register.setMaxMeters(0);
        register.setPayStatus(false);
        register.setPrice(price);
        register.setService(service);
        return register;
    }
}