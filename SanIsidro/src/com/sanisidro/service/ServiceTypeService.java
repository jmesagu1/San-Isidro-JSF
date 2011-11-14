package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.ServiceType;
import com.sanisidro.to.ServiceTypeTO;

public class ServiceTypeService
{	
	public List<ServiceTypeTO> getAllServiceTypes() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select st from ServiceType st");
        List<ServiceType> rs = query.getResultList();
        List<ServiceTypeTO> result = new ArrayList<ServiceTypeTO>();
        for (ServiceType serviceType : rs) {
			result.add(GenericEntityTO.getTO(serviceType, new ServiceTypeTO()));
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}