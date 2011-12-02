package com.sanisidro.wrapper;

import java.util.Calendar;
import java.util.List;

import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.manager.FareManager;
import com.sanisidro.manager.LoginManager;
import com.sanisidro.manager.MeterManager;
import com.sanisidro.manager.ServiceFareUserManager;
import com.sanisidro.manager.ServiceStatusManager;
import com.sanisidro.manager.ServiceTypeManager;
import com.sanisidro.manager.UserManager;
import com.sanisidro.manager.UserTypeManager;
import com.sanisidro.manager.ZoneManager;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.MeterTO;
import com.sanisidro.to.ServiceFareUserTO;
import com.sanisidro.to.ServiceStatusTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserLoginTO;
import com.sanisidro.to.UserTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.to.ZoneTO;

public class SanIsidroWrapper {
	
	
	public static SanIsidroWrapper getInstance ()
	{
		return new SanIsidroWrapper();		
	}
	
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
	
	public UserTypeTO createUserType(UserTypeTO userType) {
		return new UserTypeManager().createUserType(userType);
	}
	
	public UserLoginTO login (UserLoginTO userLoginTO) throws Exception
	{
		return LoginManager.getInstance().login(userLoginTO);
	}
	
	public boolean updateUserType(UserTypeTO userType) {
		return new UserTypeManager().updateUserType(userType);
	}
	
	public List<UserTypeTO> getAllUserTypes() {
		return new UserTypeManager().getAllUserTypes();
	}
	
	public FareTO createFare(FareTO fare) {
		return new FareManager().create(fare);
	}
	
	public boolean updateFare(FareTO fare) {
		return new FareManager().update(fare);
	}
	
	public List<FareTO> getAllFares() {
		return new FareManager().getAllFares();
	}
	
	public ServiceFareUserTO createServiceFareUser(ServiceFareUserTO sfu) {
		return new ServiceFareUserManager().create(sfu);
	}

	public boolean updateServiceFareUser(ServiceFareUserTO sfu, ServiceFareUserPK oldPK) {
		return new ServiceFareUserManager().update(sfu, oldPK);
	}

	public List<ServiceFareUserTO> getAllServiceFareUser() {
		return new ServiceFareUserManager().getAllServiceFareUser();
	}

	public List<MeterTO> searchMeters(String serie, double price, Calendar dateFrom, Calendar dateTo) 
			throws Exception  
	{
		return new MeterManager().searchMeters(serie, price, dateFrom, dateTo);
	}

	public List<MeterTO> searchMetersByUser(String name, String lastName, long dni) throws Exception  
	{
		return new MeterManager().searchMetersByUser(name, lastName, dni);
	}

	public List<MeterTO> searchMetersByService(String farmName, double priceSuscription, 
			long payNumber, Calendar dateFrom, Calendar dateTo, long zoneId, long serviceTypeId) 
			throws Exception  
	{
		return new MeterManager().searchMetersByService(farmName, priceSuscription, payNumber, 
				dateFrom, dateTo, zoneId, serviceTypeId);
	}

	public ServiceStatusTO createServiceStatus(ServiceStatusTO serviceStatus)
	{
		return new ServiceStatusManager().createServiceStatus(serviceStatus);
	}

	public boolean updateServiceStatus(ServiceStatusTO serviceStatus) {
		return new ServiceStatusManager().updateServiceStatus(serviceStatus);
	}
	
	public UserTypeTO getUserTypeByID(UserTypeTO userTypeTO)
	{
		return new UserTypeManager().getUserTypeByID(userTypeTO);
	}

	public List<ServiceStatusTO> getAllServiceStatus() {
		return new ServiceStatusManager().getAllServiceStatus();
	}

	public MeterTO createMeter(MeterTO meter) {
		return new MeterManager().createMeter(meter);
	}
	
	public UserTO createUser(UserTO userTO)
	{
		return UserManager.getInstance().createUser(userTO);
	}
}