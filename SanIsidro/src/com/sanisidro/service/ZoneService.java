package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Zone;
import com.sanisidro.to.ZoneTO;

public class ZoneService {
	
	public List<ZoneTO> getAllZones() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select z from Zone z");
        List<Zone> zones = query.getResultList();
        List<ZoneTO> result = new ArrayList<ZoneTO>();
        for (Zone zone : zones) {
			result.add(GenericEntityTO.getTO(zone, new ZoneTO()));
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}