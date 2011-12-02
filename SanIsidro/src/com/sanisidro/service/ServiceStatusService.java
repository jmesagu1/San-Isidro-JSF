package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.ServiceStatus;
import com.sanisidro.to.ServiceStatusTO;

public class ServiceStatusService {

	public List<ServiceStatusTO> getAllServiceStatus() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select ss from ServiceStatus ss");
        List<ServiceStatus> statuses = query.getResultList();
        List<ServiceStatusTO> result = new ArrayList<ServiceStatusTO>();
        for (ServiceStatus serviceStatus : statuses) {
        	ServiceStatusTO to = GenericEntityTO.getTO(serviceStatus); 
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}