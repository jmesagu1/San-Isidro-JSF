package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Zone;
import com.sanisidro.to.ZoneTO;

public class ZoneService implements IService{

	@Override
	public Object create(Object obj, EntityManager em) {
		ZoneTO zoneTO = (ZoneTO) obj;
		em.getTransaction().begin();
		Zone zone = new Zone();
		zone.setName(zoneTO.getName());
		em.persist(zone);
		zoneTO.setId(zone.getId());
		em.getTransaction().commit();
		return zoneTO;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		ZoneTO zoneTO = (ZoneTO) obj;
		em.getTransaction().begin();
		Zone zone = em.find(Zone.class, zoneTO.getId());
		if (zone != null) {
			zone.setName(zoneTO.getName());
			result = true;
		}
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Object getDetails(Object obj, EntityManager em) {
		ZoneTO zoneTO = (ZoneTO) obj;
		em.getTransaction().begin();
		Zone zone = em.find(Zone.class, zoneTO.getId());
		if (zone != null) {
			zoneTO.setName(zone.getName());
			return zoneTO;
		} else {
			return null;
		}
	}
	
	public List<ZoneTO> getAllZones() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select z from Zone z");
        List<Zone> zones = query.getResultList();
        List<ZoneTO> result = new ArrayList<ZoneTO>();
        for (Zone zone : zones) {
			ZoneTO to = new ZoneTO();
			to.setId(zone.getId());
			to.setName(zone.getName());
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}