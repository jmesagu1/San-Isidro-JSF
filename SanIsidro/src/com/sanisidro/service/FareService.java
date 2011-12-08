package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Fare;
import com.sanisidro.to.FareTO;

public class FareService 
{	
	public List<FareTO> getAllFares() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select f from Fare f");
        List<Fare> fares = query.getResultList();
        List<FareTO> result = new ArrayList<FareTO>();
        for (Fare fare : fares) {
			result.add(GenericEntityTO.getTO(fare, new FareTO()));
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}