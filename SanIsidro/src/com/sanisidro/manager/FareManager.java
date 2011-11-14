package com.sanisidro.manager;

import java.util.List;

import com.sanisidro.entity.Fare;
import com.sanisidro.service.FareService;
import com.sanisidro.service.GenericService;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;

public class FareManager {

	public FareTO create(FareTO fare) {
		try 
		{
			return GenericService.create(new Fare(), fare);
		}
		catch (Exception e) {
			e.printStackTrace();
			fare.setId(-1);
			return fare;
		}
	}

	public boolean update(FareTO fare) {
		try {
			GenericService.update(new Fare(), fare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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