package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sanisidro.entity.Service;
import com.sanisidro.to.ServiceTO;

public class ServicesService {

	public List<ServiceTO> getActiveServices() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
		String strQuery = "select m from Service s where s.deleted = false";
		List<Service> rs = em.createQuery(strQuery).getResultList();
		List<ServiceTO> services = new ArrayList<ServiceTO>();
		for (Service service : rs) {
			services.add(GenericEntityTO.getTO(service, new ServiceTO()));
		}
    	return services;
	}
}
