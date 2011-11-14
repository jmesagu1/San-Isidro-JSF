package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.service.CRUDService;
import com.sanisidro.service.FareService;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;

public class FareManager {
	
	public static final String DATA_SERVICE = "com.sanisidro.service.FareService";

	public FareTO create(FareTO fare) {
		try 
		{
			return (FareTO) new CRUDService().create(DATA_SERVICE, fare);
		}
		catch (Exception e) {
			e.printStackTrace();
			fare.setId(-1);
			return fare;
		}
	}

	public boolean update(FareTO fare) {
		return new CRUDService().update(DATA_SERVICE, fare);
	}

	public FareTO getDetails(FareTO fare) {
		try 
		{
			return (FareTO) new CRUDService().get(DATA_SERVICE, fare);
		}
		catch (Exception e) {
			e.printStackTrace();
			fare.setId(-1);
			return fare;
		}
	}
	
	public List<FareTO> getAllFares() {
		try 
		{
			List<FareTO> fares = new FareService().getAllFares();
			List<ServiceFareUserTO> compositeFares = new ServiceFareUserManager().getAllServiceFareUser();
			for (int i = 0; i < fares.size(); i++) {
				for (int j = 0; j < compositeFares.size(); j++) {
					if (fares.get(i).getId() == compositeFares.get(j).getFare().getId()) {
						fares.remove(i);
					}
				}
			}
			return fares;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}